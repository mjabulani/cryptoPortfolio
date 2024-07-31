package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CoinFetcher {

    private final HttpClient httpClient;
    private final String baseUri = "https://api.coingecko.com/api/v3/coins/list";
    private final String apiKey = "CG-N7A3cKPeL2a7DYHBwVbMGBPr";

    public CoinFetcher(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String fetchCoinList() {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUri))
                .header("accept", "application/json")
                .header("x-cg-demo-api-key", apiKey)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
