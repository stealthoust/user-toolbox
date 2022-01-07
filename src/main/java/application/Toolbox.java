package application;

import classes.ManagerCovid;
import classes.ZmienOkno;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Toolbox implements Initializable {
    public ManagerCovid managerCovid;
    public Button btn_covid;
    public Button btn_waluta;
    public Text generalDeaths;
    public Text generalInfections;
    public Text generalRecovered;

    public Text todayInfections;
    public Text todayDeaths;
    public Text deathsGenderMale;
    public Text deathsGenderFemale;
    public Text deathsAgeRanges;
    public ComboBox comboList;

    {
        try {
            managerCovid = new ManagerCovid();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Button btn_pogoda;
    public void okno_pogoda(ActionEvent actionEvent) {
        try
        {
            ZmienOkno.zmienScene("weather.fxml", 1234, 704, btn_pogoda);
        }
        catch (Exception e){

            System.out.println("Błąd w wczytaniu okna");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String[] comboValue = {"0-10","11-20","21_30","31-40","41-50","51-60","61-70","71-80","81+"};



//        System.out.println(managerCovid.getAgeRangesDeaths(8));
        generalDeaths.setText("Ogolna liczba zgonow:    "+managerCovid.getDeathGeneral());
        generalInfections.setText("Ogolna liczba infekcji:    "+managerCovid.getInfectionsGeneral());
        generalRecovered.setText("Ogolna liczba ozdrowiencow:    "+managerCovid.getRecoveredGeneral());

        todayDeaths.setText("Liczba zgonow:    "+managerCovid.getNewDeathsToday());
        todayInfections.setText("Liczba infekcji:   "+managerCovid.getNewInfectionsToday());
        deathsGenderMale.setText("Liczba smierci mezczyzni:    "+managerCovid.getDeathsGenderMale());
        deathsGenderFemale.setText("Liczba zgonow kobiety:    "+managerCovid.getDeathsGenderFemale());



    }

    public void zmienTekst(){


        String s = comboList.getValue().toString();
        switch (s){
        case "0-10 lat":
            deathsAgeRanges.setText("Liczba smierci w przedziale:   "+managerCovid.getAgeRangesDeaths(0));
            break;
            case "11-20 lat":
                deathsAgeRanges.setText("Liczba smierci w przedziale:   "+managerCovid.getAgeRangesDeaths(1));
                break;
            case "21-30 lat":
                deathsAgeRanges.setText("Liczba smierci w przedziale:   "+managerCovid.getAgeRangesDeaths(2));
                break;
            case "31-40 lat":
                deathsAgeRanges.setText("Liczba smierci w przedziale:   "+managerCovid.getAgeRangesDeaths(3));
                break;
            case "41-50 lat":
                deathsAgeRanges.setText("Liczba smierci w przedziale:   "+managerCovid.getAgeRangesDeaths(4));
                break;
            case "51-60 lat":
                deathsAgeRanges.setText("Liczba smierci w przedziale:   "+managerCovid.getAgeRangesDeaths(5));
                break;
            case "61-70 lat":
                deathsAgeRanges.setText("Liczba smierci w przedziale:   "+managerCovid.getAgeRangesDeaths(6));
                break;
            case "71-80 lat":
                deathsAgeRanges.setText("Liczba smierci w przedziale:   "+managerCovid.getAgeRangesDeaths(7));
                break;
            case "80+ lat":
                deathsAgeRanges.setText("Liczba smierci w przedziale:   "+managerCovid.getAgeRangesDeaths(8));
                break;
            default:
                deathsAgeRanges.setText("Brak danych");
                break;
        }

    }

}
