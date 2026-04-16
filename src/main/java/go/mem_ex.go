package main

func main() {
	go func() {
		http.ListenAndServe("localhost:6060", nil)
	}()
}
