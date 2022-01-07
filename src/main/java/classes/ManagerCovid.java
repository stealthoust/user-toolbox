package classes;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerCovid {


    private Date reportDate;
    private String InfectionsGeneral; //Zakazenia ogolnie
    private String DeathGeneral; //Zgony ogolnie
    private String RecoveredGeneral; //Wyleczone ogolnie
    private String NewInfectionsToday; // Nowe infekcje dzisiaj
    private String NewDeathsToday; //Zgony dzisaij
    private List<deathAgeRanges> AgeRanges; //Tablica z przedziałami wiekowymi oraz danymi zgonami z tego przedziału
    //ArrayList< Object > AgeRanges = new ArrayList < Object > ();
//    private String DeathsTodayAgeRanges; // Zmienna z liczbą śmierci z danego przedziału
    private String DeathsGenderMale; //Zgony podzielone na plec
    private String DeathsGenderFemale; //Zgony podzielone na plec



    public ManagerCovid() throws Exception{
        Gson gson = new Gson();
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create("https://koronawirus-api.herokuapp.com/api/covid19/daily" )).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String odpowiedz = response.body();
        Covid infections = gson.fromJson(odpowiedz,Covid.class);


        this.InfectionsGeneral = Integer.toString(infections.general.infections);
        this.DeathGeneral = Integer.toString(infections.general.deaths);
        this.RecoveredGeneral = Integer.toString(infections.general.recovered);
        this.NewInfectionsToday = Integer.toString(infections.today.newInfections); //Today
        this.NewDeathsToday = Integer.toString(infections.today.newDeaths);
        this.AgeRanges = infections.today.deathAgeRanges;
//        this.DeathsTodayAgeRanges = Integer.toString(infections.today.deathAgeRanges.get(0).deaths);
        this.DeathsGenderMale = Integer.toString(infections.today.deathGender.male);
        this.DeathsGenderFemale = Integer.toString(infections.today.deathGender.female);
        this.reportDate = infections.reportDate;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public String getInfectionsGeneral() {
        return InfectionsGeneral;
    }

    public String getDeathGeneral() {
        return DeathGeneral;
    }

    public String getRecoveredGeneral() {
        return RecoveredGeneral;
    }

    public String getNewInfectionsToday() {
        return NewInfectionsToday;
    }

    public String getNewDeathsToday() {
        return NewDeathsToday;
    }

    public int getAgeRangesDeaths(int i) {

        return AgeRanges.get(i).deaths;
    }
    public String getAgeRangesYears(int i){

        return AgeRanges.get(i).ageRange;
    }

//    public String getDeathsTodayAgeRanges() {
//        return DeathsTodayAgeRanges;
//    }

    public String getDeathsGenderMale() {
        return DeathsGenderMale;
    }

    public String getDeathsGenderFemale() {
        return DeathsGenderFemale;
    }






}
