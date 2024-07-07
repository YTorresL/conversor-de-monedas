package com.torres.services;

import com.google.gson.Gson;
import com.torres.models.ConversionRates;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SolicitudesAPI {
    static String API_KEY = "6e898af2b0952c9e91b3ecbb";

    public static String SolicitarAPI(String codigo) throws IOException, InterruptedException {
        HttpResponse<String> response;

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + codigo))
                    .build();

            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response.body();
    }
}
