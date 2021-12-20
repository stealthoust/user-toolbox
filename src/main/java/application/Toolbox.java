package application;

import classes.ZmienOkno;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Toolbox {
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
}
