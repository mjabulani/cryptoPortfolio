package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.FileAlreadyExistsException;
import java.util.logging.Logger;

public class CoinFetcher {

    private final HttpClient httpClient;
    final String baseUri = "https://api.coingecko.com/api/v3/coins/list";
    final String apiKey = "CG-N7A3cKPeL2a7DYHBwVbMGBPr";

    public CoinFetcher(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public void saveCoinListToFile() {

        File file = new File("src/main/resources/coinList.txt");

        try {
            FileWriter fileWriter = new FileWriter(file);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUri))
                    .header("accept", "application/json")
                    .header("x-cg-demo-api-key", apiKey)
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            fileWriter.write(response.body());
            fileWriter.flush();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
