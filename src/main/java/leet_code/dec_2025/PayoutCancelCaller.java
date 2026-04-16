package leet_code.dec_2025;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class PayoutCancelCaller {

    private static final String ENDPOINT = "http://localhost:8777/api/1.0/wallet-payment/cancel";
    private static final Duration TIMEOUT = Duration.ofSeconds(15);

    public static void main(String[] args) {
        List<String> paymentKeys = List.of(
//                "75890a98-de1c-4c64-a879-59aa81a7a952"//,
                "91ef890a-73b7-4a47-a9c7-726d36e92b02",
                "60b71b03-5a13-42ef-83bd-42c814221d28",
                "96416086-bd7f-4945-a75e-e0e30f9784c5",
                "6d96164d-2c57-4d86-a964-eacbf9e3cd49",
                "eebdb7c6-7984-46ae-98e9-0c6b85ca76ad",
                "cd05910b-583b-4fa9-93e2-3edb0d7fe25c",
                "84db60bc-bef9-4318-9f03-12c7901c6dcc",
                "d13e90de-6d1f-4573-9d49-9da5dd32455d",
                "4a40a295-ac88-4051-b876-48ae6b8745c9",
                "5a6a0f05-3ee6-424a-9cb1-cef74355ec95",
                "a71d9bb7-3a16-4b3b-a747-3412a00f2af5",
                "3d33e406-e265-4e42-ba89-f072742bf2fe",
                "f4aed504-2068-4c88-8448-9d2fb5e39ab9",
                "a3e4143a-1f34-4ffa-a79e-6d728e75dce7",
                "72a94026-e995-4dfe-b1bf-68eb8c4c02c3",
                "7fe16e24-29e5-47cb-8b08-6093847ce90b",
                "b25dfd5b-4d9c-4dd0-8b79-913251fd8f98",
                "47bae4f8-838b-4aab-b3c8-5dfb12461059",
                "b6d0a895-d3ea-489d-ab10-bfe6cd0a6fad",
                "b326fe36-536b-4863-9654-e6bf93c5eb1b",
                "e1d2675e-5c03-4ca9-807a-42a3daced95d",
                "fe3269c6-19cf-49f6-ba28-e48c0807e750",
                "2cbd9a4d-af97-45a2-9e2c-e40583b072f7",
                "a5852425-088a-4713-b90e-5e03c0602830",
                "933dce72-cb60-4dde-8275-9d8d13b80b81",
                "39573d8b-49b9-43a0-9e9a-c3251f837c91",
                "ff86e0d2-7729-4822-bbad-1408228cbc7d",
                "2c534764-933e-4399-bc6a-23e31b500762",
                "0ad0dee0-2f41-48af-bc6d-eefea376c409",
                "8c63333b-fbba-48b9-b9b4-f6dd4edd338c",
                "b781a934-0e54-4cc2-80b6-8a524a36cfae",
                "5b3fa9af-e4f6-4d19-997b-4b5402a204cf",
                "48902125-101f-48f8-84ba-eb2d4fedfeec",
                "af6928bc-6641-4a73-8fa5-206f9c0b29fc",
                "99312d65-04bf-4409-b203-5f2f2256383e",
                "39e3249e-e677-4a33-b836-c238e4ac3258",
                "40dbe992-b4ff-45af-9cf5-9ab302701c5d",
                "9a84097c-f844-4701-91ff-a2e6f03a0943",
                "56cdd43f-6fb2-41dc-a703-fb5d1c30ffd2",
                "cbffa08a-4fce-4fce-b755-c10670700908",
                "69adc356-2d89-44bd-97d7-2c9d365f1303",
                "45a9bd61-db0e-47e9-9f07-c10cd40b5976",
                "23918b23-c7d0-4fe8-bb2a-d9406cd78580",
                "44f6d8b0-7f95-4d1d-a8f4-05f22eb804b0",
                "a885aa6e-1fa1-420d-ba65-787e8271c4ac",
                "7ed0877c-30a3-49e6-98cb-e214e172eba1",
                "492536bf-3439-4991-b823-b4bd7deee06a",
                "2d7f4556-932c-41cc-8f72-ee5c5a7e20f1",
                "f48aeab6-25f0-414a-9bcd-04ed0f0e8d79",
                "1aa1a6f3-9633-4769-974e-d49af92caeea",
                "6b58ccab-35ae-4d90-8487-47db2f04098c",
                "2d30ef4d-99b6-4c82-9a97-379edd46e23c",
                "dd8851db-7c3e-4fb3-824a-b7844cb017de",
                "7d659810-1f28-4c66-8eb0-0b7c82f43033",
                "1f8199ca-f431-4555-a5ca-3cb870fe78a4",
                "1d941045-c165-45db-8e97-c2171fa1f1fc",
                "98e6fbc5-6084-429f-963f-9b3c8bd39eb6",
                "d35ce1cc-8465-4c2f-a1db-8d5e80e2aa9b",
                "d9ff0504-bd74-4a17-a47b-3711504fce9e",
                "76e801dd-7a79-4041-bd54-8b68d60972aa",
                "9e3d4648-57c4-411f-8cef-8311a0eb04c9",
                "f89f234d-5420-4987-82c1-a77627ad0a54",
                "f0375b7b-07d2-46e2-9a48-c259a253e38f"
        );

        // Safe concurrency limit
        ExecutorService executor = Executors.newFixedThreadPool(10);

        HttpClient client = HttpClient.newBuilder()
                .executor(executor)
                .connectTimeout(TIMEOUT)
                .build();

        System.out.println("Total payment keys: " + paymentKeys.size());

        CompletableFuture.allOf(paymentKeys.stream()
                .map(key -> sendCancelRequest(client, key)).toArray(CompletableFuture[]::new)).join();

        executor.shutdown();
        System.out.println("All cancel requests finished.");
    }

    private static CompletableFuture<Void> sendCancelRequest(HttpClient client, String paymentKey) {
        String jsonBody = "{\"paymentKey\":\"" + escapeJson(paymentKey) + "\"}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(ENDPOINT))
                .timeout(TIMEOUT)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> {
                    int status = response.statusCode();
                    String body = response.body();

                    System.out.printf(
                            "paymentKey=%s | status=%d | body=%s%n",
                            paymentKey,
                            status,
                            shorten(body, 500)
                    );
                })
                .exceptionally(ex -> {
                    System.err.printf("paymentKey=%s | ERROR=%s%n", paymentKey, ex.getMessage());
                    return null;
                });
    }

    private static String escapeJson(String value) {
        // paymentKey is UUID and safe, but keeping minimal JSON escape anyway
        return value.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    private static String shorten(String s, int maxLen) {
        if (s == null) return "";
        if (s.length() <= maxLen) return s;
        return s.substring(0, maxLen) + "...";
    }
}
