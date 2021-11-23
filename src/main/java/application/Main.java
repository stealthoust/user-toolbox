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

public class Main extends Application {

    public static void main(String[] args) throws IOException, InterruptedException {
        launch(args);

        System.out.println(getPogoda.getP().name);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("toolbox.fxml"));
        primaryStage.setTitle("VaBank");
        primaryStage.setScene(new Scene(root, 905, 495));
        //primaryStage.initStyle(StageStyle.UNDECORATED); //Pasek zadan
        primaryStage.show();
        primaryStage.setResizable(false);

    }


}
