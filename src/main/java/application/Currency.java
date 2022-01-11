package application;

import classes.ManagerWaluty;
import classes.Waluta;
import classes.ZmienOkno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class Currency implements Initializable {

    @FXML
    private TextField wpiszkwota;
    @FXML
    private Button btn_wyczysc, btn_wpogoda, btn_wcovid;
    @FXML
    private ComboBox listawaluta1, listawaluta2;
    @FXML
    private Label danewaluta1, danewaluta11, danewaluta2, danewaluta21, danekwota;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        wypelnijListaWaluta();
    }

    public void wypelnijListaWaluta() {

        listawaluta1.getItems().add("AUD");
        listawaluta1.getItems().add("BRL");
        listawaluta1.getItems().add("CAD");
        listawaluta1.getItems().add("CZK");
        listawaluta1.getItems().add("DKK");
        listawaluta1.getItems().add("EUR");
        listawaluta1.getItems().add("HUF");
        listawaluta1.getItems().add("UAH");
        listawaluta1.getItems().add("ISK");
        listawaluta1.getItems().add("HRK");
        listawaluta1.getItems().add("NOK");
        listawaluta1.getItems().add("GBP");
        listawaluta1.getItems().add("RUB");
        listawaluta1.getItems().add("SEK");
        listawaluta1.getItems().add("CHF");
        listawaluta1.getItems().add("TRY");
        listawaluta1.getItems().add("USD");
        listawaluta1.getItems().add("KRW");
        listawaluta1.getItems().add("JPY");
        listawaluta1.getItems().add("CNY");
        listawaluta1.getItems().add("PLN");

        listawaluta2.getItems().add("AUD");
        listawaluta2.getItems().add("BRL");
        listawaluta2.getItems().add("CAD");
        listawaluta2.getItems().add("CZK");
        listawaluta2.getItems().add("DKK");
        listawaluta2.getItems().add("EUR");
        listawaluta2.getItems().add("HUF");
        listawaluta2.getItems().add("UAH");
        listawaluta2.getItems().add("ISK");
        listawaluta2.getItems().add("HRK");
        listawaluta2.getItems().add("NOK");
        listawaluta2.getItems().add("GBP");
        listawaluta2.getItems().add("RUB");
        listawaluta2.getItems().add("SEK");
        listawaluta2.getItems().add("CHF");
        listawaluta2.getItems().add("TRY");
        listawaluta2.getItems().add("USD");
        listawaluta2.getItems().add("KRW");
        listawaluta2.getItems().add("JPY");
        listawaluta2.getItems().add("CNY");
        listawaluta2.getItems().add("PLN");

    }



    public void listawaluta1Akcja(ActionEvent event) {
        danewaluta1.setText(String.valueOf(listawaluta1.getValue()));
        aktualizujInfo1(String.valueOf(listawaluta1.getValue()));
        aktualizujPodglad();

    }

    public void listawaluta2Akcja(ActionEvent event) {
        danewaluta2.setText(String.valueOf(listawaluta2.getValue()));
        aktualizujInfo2(String.valueOf(listawaluta2.getValue()));
        aktualizujPodglad();

    }

    public void aktualizujInfo1(String waluta) {
        switch (waluta) {
            case "AUD":
                danewaluta11.setText("Dolar australijski");
                break;
            case "BRL":
                danewaluta11.setText("Real brazylijski");
                break;
            case "CAD":
                danewaluta11.setText("Dolar kanadyjski");
                break;
            case "CZK":
                danewaluta11.setText("Korona czeska");
                break;
            case "DKK":
                danewaluta11.setText("Korona dunska");
                break;
            case "EUR":
                danewaluta11.setText("Euro");
                break;
            case "HUF":
                danewaluta11.setText("Forint");
                break;
            case "UAH":
                danewaluta11.setText("Hrywna");
                break;
            case "ISK":
                danewaluta11.setText("Korona islandzka");
                break;
            case "HRK":
                danewaluta11.setText("Kuna chorwacka");
                break;
            case "NOK":
                danewaluta11.setText("Korona norweska");
                break;
            case "GBP":
                danewaluta11.setText("Brytyjski funt szterling");
                break;
            case "RUB":
                danewaluta11.setText("Rubel rosyjski");
                break;
            case "SEK":
                danewaluta11.setText("Korona szwedzka");
                break;
            case "CHF":
                danewaluta11.setText("Frank szwajcarski");
                break;
            case "TRY":
                danewaluta11.setText("Lira turecka");
                break;
            case "USD":
                danewaluta11.setText("Dolar amerykanski");
                break;
            case "KRW":
                danewaluta11.setText("Won");
                break;
            case "JPY":
                danewaluta11.setText("Jen japonski");
                break;
            case "CNY":
                danewaluta11.setText("Juan");
                break;
            case "PLN":
                danewaluta11.setText("Polski Zloty");
                break;
            default:
                danewaluta11.setText("Brak");
                break;
        }
    }

        public void aktualizujInfo2(String waluta){
            switch(waluta){
                case "AUD":
                    danewaluta21.setText("Dolar australijski");
                    break;
                case "BRL":
                    danewaluta21.setText("Real brazylijski");
                    break;
                case "CAD":
                    danewaluta21.setText("Dolar kanadyjski");
                    break;
                case "CZK":
                    danewaluta21.setText("Korona czeska");
                    break;
                case "DKK":
                    danewaluta21.setText("Korona dunska");
                    break;
                case "EUR":
                    danewaluta21.setText("Euro");
                    break;
                case "HUF":
                    danewaluta21.setText("Forint");
                    break;
                case "UAH":
                    danewaluta21.setText("Hrywna");
                    break;
                case "ISK":
                    danewaluta21.setText("Korona islandzka");
                    break;
                case "HRK":
                    danewaluta21.setText("Kuna chorwacka");
                    break;
                case "NOK":
                    danewaluta21.setText("Korona norweska");
                    break;
                case "GBP":
                    danewaluta21.setText("Brytyjski funt szterling");
                    break;
                case "RUB":
                    danewaluta21.setText("Rubel rosyjski");
                    break;
                case "SEK":
                    danewaluta21.setText("Korona szwedzka");
                    break;
                case "CHF":
                    danewaluta21.setText("Frank szwajcarski");
                    break;
                case "TRY":
                    danewaluta21.setText("Lira turecka");
                    break;
                case "USD":
                    danewaluta21.setText("Dolar amerykanski");
                    break;
                case "KRW":
                    danewaluta21.setText("Won");
                    break;
                case "JPY":
                    danewaluta21.setText("Jen japonski");
                    break;
                case "CNY":
                    danewaluta21.setText("Juan");
                    break;
                case "PLN":
                    danewaluta21.setText("Polski Zloty");
                    break;
                default:
                    danewaluta21.setText("Brak");
                    break;
            }

    }

    public void aktualizujPodglad() {

        if (!danewaluta1.getText().isEmpty() && !danewaluta2.getText().isEmpty() && !wpiszkwota.getText().isEmpty()) {
            DecimalFormat df = new DecimalFormat("###.##");
            String skrot1 = danewaluta1.getText();
            String skrot2 = danewaluta2.getText();
            double kurs1, kurs2;

            if (jestLiczba(wpiszkwota.getText()) == true) {
                double kwota = Double.parseDouble(wpiszkwota.getText());
                if (kwota >= 0) {
                    if (!skrot1.equals("PLN")) {
                        kurs1 = sprawdzWaluta(skrot1);
                    } else kurs1 = 1.0;

                    if (!skrot2.equals("PLN")) {
                        kurs2 = sprawdzWaluta(skrot2);
                    } else kurs2 = 1.0;

                    Double przelicznik = kurs1 / kurs2;
                    kwota = kwota * przelicznik;

                    danekwota.setText(df.format(kwota) + " " + skrot2);

                }
            }
        }
    }

    public double sprawdzWaluta(String skrot) {
        try {
            return ManagerWaluty.getKurs(skrot);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void wyczyscButton()   // Guzik wyczyszczenia pola
    {
        wpiszkwota.setText("");
        danekwota.setText("");
    }

    public boolean jestLiczba(String tekst) {
        try {
            Float wartosc = Float.parseFloat(tekst);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public void okno_pogoda(ActionEvent actionEvent) {
        try
        {
            ZmienOkno.zmienScene("weather2.fxml", 1400, 704, btn_wpogoda);
        }
        catch (Exception e){
            System.out.println("Błąd w wczytaniu okna");
        }
    }

    public void okno_covid(ActionEvent actionEvent) {
        try
        {
            ZmienOkno.zmienScene("toolbox.fxml", 1400, 704, btn_wcovid);
        }
        catch (Exception e){
            System.out.println("Błąd w wczytaniu okna");
        }
    }

}