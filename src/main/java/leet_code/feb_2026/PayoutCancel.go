// cancel_payouts.go
// Run: go run cancel_payouts.go

package main

import (
	"bytes"
	"fmt"
	"io"
	"net/http"
	"time"
)

const baseURL = "http://localhost:8776"

func cancelPayout(client *http.Client, paymentKey string) (int, string, error) {
	url := fmt.Sprintf("%s/payout-transactions/%s/cancel", baseURL, paymentKey)

	// Endpoint expects JSON; send empty JSON body by default
	body := bytes.NewBufferString(`{}`)

	req, err := http.NewRequest(http.MethodPost, url, body)
	if err != nil {
		return 0, "", err
	}
	req.Header.Set("Content-Type", "application/json")

	resp, err := client.Do(req)
	if err != nil {
		return 0, "", err
	}
	defer resp.Body.Close()

	b, _ := io.ReadAll(resp.Body)
	return resp.StatusCode, string(b), nil
}

func main() {
	paymentKeys := []string{
		"03e818c4-2f6a-4a70-9d54-6443dc10d14f"}

	client := &http.Client{
		Timeout: 30 * time.Second,
	}

	failed := 0

	for _, key := range paymentKeys {
		status, respBody, err := cancelPayout(client, key)
		if err != nil {
			failed++
			fmt.Printf("❌ Error:  %s | %v\n", key, err)
			continue
		}

		if status >= 200 && status < 300 {
			fmt.Printf("✅ Canceled: %s | HTTP %d\n", key, status)
			if len(respBody) > 0 {
				fmt.Printf("   Response: %s\n", respBody)
			}
		} else {
			failed++
			fmt.Printf("❌ Failed:   %s | HTTP %d\n", key, status)
			if len(respBody) > 0 {
				fmt.Printf("   Response: %s\n", respBody)
			}
		}
	}

	if failed > 0 {
		// non-zero exit code if any failed
		panic(fmt.Sprintf("%d request(s) failed", failed))
	}
}
