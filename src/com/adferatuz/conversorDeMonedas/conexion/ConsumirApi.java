package com.adferatuz.conversorDeMonedas.conexion;

import com.adferatuz.conversorDeMonedas.modelos.ConversionDeMoneda;
import com.adferatuz.conversorDeMonedas.modelos.MonedaConvertida;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumirApi {
    public MonedaConvertida convertirMoneda(String moneda) {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/dbe3d57a24a1e8561a4ba555/latest/" + moneda);
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), MonedaConvertida.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo hacer la convresion de la moneda " + e);
        }
    }
}
