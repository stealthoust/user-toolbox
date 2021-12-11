package application;


import classes.Pogoda;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import classes.*;
import javafx.stage.StageStyle;

import javax.swing.text.Document;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;

public class Main extends Application {

    public static void main(String[] args) throws Exception {




        int test = getCovid.getNewInfectionsToday();
        System.out.println(test + " TEST");
        System.out.println(getCovid.getDeathsGenderMale() + " TEST 2");
        System.out.println(getCovid.getDeathsGenderFemale() + " TEST 3");
        var Kurs123 = new getWaluta();
        double euro = Kurs123.getKurs("EUR");
        double dolar = Kurs123.getKurs("USD");
        System.out.println(euro);
        System.out.println(dolar);



        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("weather.fxml"));
        primaryStage.setTitle("VaBank");
        primaryStage.setScene(new Scene(root, 1042, 681));
        //primaryStage.initStyle(StageStyle.UNDECORATED); //Pasek zadan
        primaryStage.show();
        primaryStage.setResizable(false);

    }


}
