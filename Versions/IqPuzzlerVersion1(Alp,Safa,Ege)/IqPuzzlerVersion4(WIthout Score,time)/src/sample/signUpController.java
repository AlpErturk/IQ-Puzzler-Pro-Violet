package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;


import java.io.IOException;

public class signUpController {

    public Button backButton;

    public void registerUser(){

    }

    public void backButtonHandle() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("logInScreen.fxml"));
        Stage m = Main.getMainStage();
        Scene t = Main.getMainStage().getScene();
        t.setRoot(root);
        m.setScene(t);
        Main.setMainStage(m);
    }
}
