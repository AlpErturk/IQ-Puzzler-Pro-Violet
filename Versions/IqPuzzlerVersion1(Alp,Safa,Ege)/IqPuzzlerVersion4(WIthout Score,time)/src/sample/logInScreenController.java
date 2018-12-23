package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;


import java.io.IOException;

public class logInScreenController {
    public Button signInButton, signUpButton;
    public  TextField userNameTextField, passwordTextField;
    public ImageView image;

    public void signInButtonHandle()throws IOException{
        //set scene to main menu
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        Stage m = Main.getMainStage();
        Scene t = Main.getMainStage().getScene();
        t.setRoot(root);
        m.setScene(t);
        Main.setMainStage(m);
    }

    public void signUpButtonHandle() throws  IOException {
        //set scene to sign up screen
        Parent root = FXMLLoader.load(getClass().getResource("signUp.fxml"));
        Stage m = Main.getMainStage();
        Scene t = Main.getMainStage().getScene();
        t.setRoot(root);
        m.setScene(t);
        Main.setMainStage(m);
    }

}
