package classes;


import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class getCovid {
    public static String BaseURL = "https://koronawirus-api.herokuapp.com/api/covid19/daily";


    public static int getInfectionsGeneral() throws Exception{
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(BaseURL )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Covid infections = gson.fromJson(odpowiedz,Covid.class);

        return infections.general.infections;
    }
    public static int getDeathsGeneral() throws Exception{
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(BaseURL )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Covid infections = gson.fromJson(odpowiedz,Covid.class);

        return infections.general.deaths;
    }
    public static int getRecoveredGeneral() throws Exception{
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(BaseURL )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Covid infections = gson.fromJson(odpowiedz,Covid.class);

        return infections.general.recovered;
    }
    public static int getNewInfectionsToday() throws Exception{
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(BaseURL )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Covid infections = gson.fromJson(odpowiedz,Covid.class);

        return infections.today.newInfections;
    }
    public static int getNewDeathsToday() throws Exception{
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(BaseURL )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Covid infections = gson.fromJson(odpowiedz,Covid.class);

        return infections.today.newDeaths;
    }
    public static String getAgeRangesToday() throws Exception{
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(BaseURL )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Covid infections = gson.fromJson(odpowiedz,Covid.class);

        return infections.today.deathAgeRanges.get(0).ageRange;
    }
    public static int getDeathsToday() throws Exception{
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(BaseURL )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Covid infections = gson.fromJson(odpowiedz,Covid.class);

        return infections.today.deathAgeRanges.get(0).deaths;
    }
    public static int getDeathsGenderMale() throws Exception{
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(BaseURL )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Covid infections = gson.fromJson(odpowiedz,Covid.class);

        return infections.today.deathGender.male;
    }
    public static int getDeathsGenderFemale() throws Exception{
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(BaseURL )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Covid infections = gson.fromJson(odpowiedz,Covid.class);

        return infections.today.deathGender.female;
    }

    public static Covid getCovidStatistic() throws Exception{
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(BaseURL )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Covid infections = gson.fromJson(odpowiedz,Covid.class);

        return infections;
    }







}



