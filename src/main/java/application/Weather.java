package application;

import classes.Pogoda;
import classes.getPogoda;
import classes.getWaluta;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Weather implements Initializable {
    @FXML
    private Button szukajButton;
    @FXML
    private TextField szukajMiejscowosc;
    @FXML
    public Text miejscowoscLabel,dzienLabel,predkoscLabel,zachmurzenieLabel,cisnienieLabel,wilgotnoscLabel,temperaturaLabel,opisLabel;














    @Override
    public void initialize(URL location, ResourceBundle resources) {


        try {
            miejscowoscLabel.setText(getPogoda.getPogoda().name);
            predkoscLabel.setText(Double.toString(getPogoda.getWiatr())+" mph");
            zachmurzenieLabel.setText(Integer.toString(getPogoda.getZachmurzenie())+" %" );
            cisnienieLabel.setText(Integer.toString(getPogoda.getCisnienie())+" hPa");
            wilgotnoscLabel.setText(Integer.toString(getPogoda.getWilgotnosc()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
