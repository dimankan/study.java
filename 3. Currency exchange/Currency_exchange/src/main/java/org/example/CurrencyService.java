package org.example;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyService {

    private static final String API_URL = "https://www.cbr-xml-daily.ru/latest.js";

    public CurrencyData fetchCurrencyData() throws Exception {
        // Создаем HTTP-клиент
        HttpClient client = HttpClient.newHttpClient();

        // Создаем HTTP-запрос
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .GET()
                .build();

        // Выполняем запрос и получаем ответ
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            // Парсим JSON-ответ
            JSONObject jsonResponse = new JSONObject(response.body());

            // Извлекаем данные
            String date = jsonResponse.getString("date");
            JSONObject rates = jsonResponse.getJSONObject("rates");
            double usdRate = rates.getDouble("USD");
            double eurRate = rates.getDouble("EUR");

            // Возвращаем объект модели
            return new CurrencyData(date, usdRate, eurRate);
        } else {
            throw new RuntimeException("Ошибка API: HTTP " + response.statusCode());
        }
    }
}
