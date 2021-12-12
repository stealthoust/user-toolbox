package application;

import classes.*;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Weather implements Initializable {

    ManagerPogody managerPogody;
    String miastoSet;

    @FXML
    private Button szukajButton;
    @FXML
    private TextField szukajMiejscowosc;
    @FXML
    public Text dzienLabel,predkoscLabel,zachmurzenieLabel,cisnienieLabel,wilgotnoscLabel,temperaturaLabel,opisLabel;
    @FXML
    public Label errors,miejscowoscLabel;
    @FXML
    public  ImageView obraz;

    public Weather()
    {
        this.miastoSet="Jaroslaw".toUpperCase();
    }
private void reset()
{
    miejscowoscLabel.setText("");
    predkoscLabel.setText("");
    zachmurzenieLabel.setText("");
    cisnienieLabel.setText("");
    wilgotnoscLabel.setText("");
    temperaturaLabel.setText("");
    opisLabel.setText("");
    dzienLabel.setText("");
    obraz.setImage(null);

}
private void pokazPogode() throws IOException, InterruptedException {
    managerPogody.getPogoda();
    miejscowoscLabel.setText(managerPogody.getMiasto().toUpperCase());
    temperaturaLabel.setText(managerPogody.getTemperatura()+" C");
    dzienLabel.setText(managerPogody.getDzien().toUpperCase());
    opisLabel.setText(managerPogody.getOpis().toUpperCase());
    obraz.setImage(new Image(classes.Image.getImage(managerPogody.getIkona())));
    predkoscLabel.setText(managerPogody.getPredkoscWiatru());
    zachmurzenieLabel.setText(managerPogody.getZachmurzenie());
    cisnienieLabel.setText(managerPogody.getCisnienie());
    wilgotnoscLabel.setText(managerPogody.getWilgotnosc());
}
private void pokazPowiadomienie(String wiadomosc)
{
    errors.setText(wiadomosc);
    errors.setTextFill(Color.TOMATO);
    errors.setStyle("-fx-background-color: #fff; -fx-background-radius: 50px;");

    FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), errors);
    fadeIn.setToValue(1);
    fadeIn.setFromValue(0);
    fadeIn.play();

    fadeIn.setOnFinished(event -> {
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.play();
        pause.setOnFinished(event2 -> {
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), errors);
            fadeOut.setToValue(0);
            fadeOut.setFromValue(1);
            fadeOut.play();
        });
    });

}
    @FXML
    private void ZmienPogode(javafx.event.ActionEvent ae)
    {
        if(szukajMiejscowosc.getText().equals(""))
        {
            pokazPowiadomienie("Nazwa miasta nie moze byc pusta!");
            return;
        }
else {
            try {
                errors.setText("");
                this.miastoSet = szukajMiejscowosc.getText().trim();
                szukajMiejscowosc.setText(szukajMiejscowosc.getText().trim().toUpperCase());
                managerPogody = new ManagerPogody(miastoSet);
                pokazPogode();
            } catch (Exception e) {

                miejscowoscLabel.setText("Error!");
                miejscowoscLabel.setTextFill(Color.TOMATO);
                pokazPowiadomienie("Nie znaleziono podanego miasta.");
                reset();

                e.printStackTrace();
            }
        }
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        miejscowoscLabel.setTextAlignment(TextAlignment.CENTER);
        miejscowoscLabel.setText(miastoSet);
    managerPogody=new ManagerPogody(miastoSet);
    errors.setText("");
    try{pokazPogode();}
    catch (Exception e)
    {
        miejscowoscLabel.setText("Error! - Brak internetu!");
        miejscowoscLabel.setTextFill(Color.TOMATO);
        pokazPowiadomienie("Brak Internetu. Polacz sie i sprobuj ponownie");
        reset();

    }


    }
}
