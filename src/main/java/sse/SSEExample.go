package main

import (
	"fmt"
	"net/http"
	"time"
)

func main() {

}

type SSEServer struct {
	NewClientsChannel     chan chan []byte
	ClosingClientsChannel chan chan []byte
}

func (sseServer *SSEServer) handleConnection(rw http.ResponseWriter, req *http.Request) {
	flusher, ok := rw.(http.Flusher)

	if !ok {
		http.Error(rw, "Streaming not supported", http.StatusInternalServerError)
		return
	}
	auth := req.Header.Get("Authorization")

	fmt.Println(auth)

	rw.Header().Set("Content-Type", "text/event-stream")
	rw.Header().Set("Cache-Control", "no-cache")
	rw.Header().Set("Connection", "keep-alive")
	rw.Header().Set("X-Accel-Buffering", "no")
	rw.Header().Set("Access-Control-Allow-Origin", "*")
	rw.Header().Set("Access-Control-Allow-Methods", "POST, GET, OPTIONS")
	rw.Header().Set("Access-Control-Allow-Headers", "Content-Type, authorization, X-Requested-With")

	// register connection message channel
	messageChan := make(chan []byte)

	// signal the Server of a new client connection
	sseServer.NewClientsChannel <- messageChan

	//keeping the connection alive with keep-alive protocol
	keepAliveTickler := time.NewTicker(15 * time.Second)
	keepAliveMsg := ":keepalive\n"
	notify := req.Context().Done()

	//listen to signal to close and unregister
	go func() {
		<-notify
		sseServer.ClosingClientsChannel <- messageChan
		keepAliveTickler.Stop()
	}()
	defer func() {
		sseServer.ClosingClientsChannel <- messageChan
	}()

	for {
		select {
		//receiving a message from the Kafka channel.
		case kafkaEvent := <-messageChan:
			// Write to the ResponseWriter in SSE compatible format
			fmt.Fprintf(rw, "data: %s\n\n", kafkaEvent)
			flusher.Flush()
		case <-keepAliveTickler.C:
			fmt.Fprintf(rw, keepAliveMsg)
			flusher.Flush()
		}

	}
}
