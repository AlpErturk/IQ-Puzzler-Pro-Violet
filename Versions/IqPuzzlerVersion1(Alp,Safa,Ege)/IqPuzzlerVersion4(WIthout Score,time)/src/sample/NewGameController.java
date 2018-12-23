package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class NewGameController {

    public Button backButton;
    public Button twoDCheckBox;
    public Button threeDCheckBox;


    public void backButtonHandle() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        Stage m = Main.getMainStage();
        Scene t = Main.getMainStage().getScene();
        t.setRoot(root);
        m.setScene(t);
        Main.setMainStage(m);
    }

    public void twoDCheckBoxHandle() throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("GamePlayController.fxml"));
        Stage m = Main.getMainStage();
        Scene t = Main.getMainStage().getScene();
        t.setRoot(root);
        m.setScene(t);
        Main.setMainStage(m);
    }

    public void threeDCheckBoxHandle() throws IOException {

    }

}
