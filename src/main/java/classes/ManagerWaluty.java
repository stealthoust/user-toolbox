package classes;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;


public class ManagerWaluty {
    public static String BaseURL = "http://api.nbp.pl/api/exchangerates/rates/A/";

    public static double getKurs(String skrotWaluty) throws IOException, InterruptedException {
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(BaseURL + skrotWaluty)).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Waluta kurs = gson.fromJson(odpowiedz, Waluta.class);

        return kurs.rates[0].mid;
    }

}
