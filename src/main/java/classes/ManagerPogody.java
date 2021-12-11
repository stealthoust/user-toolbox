package classes;

import com.google.gson.Gson;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ManagerPogody {

    private String miasto;
    private String dzien;
    private String temperatura;
    private String ikona;
    private String opis;
    private String predkoscWiatru;
    private String zachmurzenie;
    private String cisnienie;
    private String wilgotnosc;

    public ManagerPogody(String miasto)
    {
        this.miasto=miasto;
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void getPogoda() throws IOException, InterruptedException {
        int d = 0;
        SimpleDateFormat df2 = new SimpleDateFormat("EEEE", Locale.ENGLISH); //Entire word/day as output
        Calendar c = Calendar.getInstance();

        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create("https://api.openweathermap.org/data/2.5/weather?q="+miasto+"&appid=5f32855c2f658e2a0eca59c4302bb315&lang=pl" )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Pogoda pogoda = gson.fromJson(odpowiedz, Pogoda.class);

        c.add(Calendar.DATE, d);

        this.miasto=pogoda.name;
        this.temperatura=Double.toString(round(pogoda.main.temp-274.15,2)) ;
        this.dzien=df2.format(c.getTime());
        this.ikona=pogoda.weather.get(0).icon;
        this.opis=pogoda.weather.get(0).description;
        this.predkoscWiatru=Double.toString(round(pogoda.wind.speed*1.609344,2))+" km/h";
        this.zachmurzenie=Integer.toString(pogoda.clouds.all);
        this.cisnienie=Integer.toString(pogoda.main.pressure);
        this.wilgotnosc=Integer.toString(pogoda.main.humidity);
    }

    public String getMiasto() {
        return miasto;
    }

    public String getDzien() {
        return dzien;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public String getIkona() {
        return ikona;
    }

    public String getOpis() {
        return opis;
    }

    public String getPredkoscWiatru() {
        return predkoscWiatru;
    }

    public String getZachmurzenie() {
        return zachmurzenie;
    }

    public String getCisnienie() {
        return cisnienie;
    }

    public String getWilgotnosc() {
        return wilgotnosc;
    }
}
