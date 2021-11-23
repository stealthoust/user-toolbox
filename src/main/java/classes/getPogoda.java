package classes;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class getPogoda {

    public static String BaseURL = "https://api.openweathermap.org/data/2.5/weather?q=rzesz%C3%B3w&appid=5f32855c2f658e2a0eca59c4302bb315";

    public static Pogoda getP() throws IOException, InterruptedException {
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(BaseURL )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Pogoda kurs = gson.fromJson(odpowiedz, Pogoda.class);

        return kurs;
    }
}
