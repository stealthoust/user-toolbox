package classes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ZmienOkno {

    public static void zmienScene(String fxml, int x, int y, Button button) throws Exception {
        Parent root = FXMLLoader.load(ZmienOkno.class.getResource("/application/"+fxml));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, x, y));
        window.setResizable(false);
    }
    public static void zmienSceneimg(String fxml, int x, int y, ImageView button) throws Exception {
        Parent root = FXMLLoader.load(ZmienOkno.class.getResource("/application/"+fxml));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, x, y));
    }
}
