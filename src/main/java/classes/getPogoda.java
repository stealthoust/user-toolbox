package classes;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class getPogoda {
    public  static String nazwa="Jaroslaw";
    public static String BaseURL = "https://api.openweathermap.org/data/2.5/weather?q="+nazwa+"&appid=5f32855c2f658e2a0eca59c4302bb315&lang=pl";


    public static String getOpis() throws IOException, InterruptedException //pobiera rozwinieta informacje na temat pogody , typu: broken clouds
    {
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(BaseURL )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Pogoda pogoda = gson.fromJson(odpowiedz, Pogoda.class);

        return pogoda.weather.get(0).description;
    }
    public static String getPrognoza() throws IOException, InterruptedException //pobiera stan pogody? typu: Clouds
    {
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(BaseURL )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Pogoda pogoda = gson.fromJson(odpowiedz, Pogoda.class);

        return pogoda.weather.get(0).main;

    }
    public static double getTemperatura() throws IOException, InterruptedException //zwraca temperature w kelvinach
    {
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(BaseURL )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Pogoda pogoda = gson.fromJson(odpowiedz, Pogoda.class);

        return pogoda.main.temp;

    }

    public static double getOdczuwalna() throws IOException, InterruptedException //zwraca odczuwalna temperature
    {
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(BaseURL )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Pogoda pogoda = gson.fromJson(odpowiedz, Pogoda.class);

        return pogoda.main.feels_like;
    }
    public static String getKraj() throws IOException, InterruptedException //zwraca kraj zapytania
    {
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(BaseURL )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Pogoda pogoda = gson.fromJson(odpowiedz, Pogoda.class);

        return pogoda.sys.country;
    }
    public static double getWiatr() throws IOException, InterruptedException {
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(BaseURL )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Pogoda pogoda = gson.fromJson(odpowiedz, Pogoda.class);

        return pogoda.wind.speed;
    }
    public static Pogoda getPogoda() throws IOException, InterruptedException //zwraca rozne informacje na temat pogody odwolanie po kropce
    {
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(BaseURL )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Pogoda pogoda = gson.fromJson(odpowiedz, Pogoda.class);

        return pogoda;
    }

    public static int getCisnienie() throws IOException, InterruptedException {
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(BaseURL )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Pogoda pogoda = gson.fromJson(odpowiedz, Pogoda.class);

        return pogoda.main.pressure;
    }
    public static int getZachmurzenie() throws IOException, InterruptedException {
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(BaseURL )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Pogoda pogoda = gson.fromJson(odpowiedz, Pogoda.class);

        return pogoda.clouds.all;
    }
    public static int getWilgotnosc() throws IOException, InterruptedException {
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(BaseURL )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Pogoda pogoda = gson.fromJson(odpowiedz, Pogoda.class);

        return pogoda.main.humidity;
    }
}
