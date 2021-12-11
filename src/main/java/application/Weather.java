package application;

import classes.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

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
    public Text miejscowoscLabel,dzienLabel,predkoscLabel,zachmurzenieLabel,cisnienieLabel,wilgotnoscLabel,temperaturaLabel,opisLabel;
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
    @FXML
    private void ZmienPogode(javafx.event.ActionEvent ae)
    {

        try {
            this.miastoSet=szukajMiejscowosc.getText().trim();
            miejscowoscLabel.setText(szukajMiejscowosc.getText().trim().toUpperCase());
            managerPogody=new ManagerPogody(miastoSet);
            pokazPogode();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        miejscowoscLabel.setText(miastoSet);
    managerPogody=new ManagerPogody(miastoSet);
    try{pokazPogode();}
    catch (Exception e)
    {reset();}


    }
}
