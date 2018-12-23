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
    ImageView loginView, logupView;

    public ImageView image;

    DatabaseManager database = new DatabaseManager();

    public void signInButtonHandle()throws IOException{
        //set scene to main menu

        //check if successful login
        String username = userNameTextField.getText();
        String password = passwordTextField.getText();

        if(database.logIn(username, password)) {
            //if login is successful
            Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            Stage m = Main.getMainStage();
            Scene t = new Scene(root);
            t.setRoot(root);
            m.setScene(t);
            Main.setMainStage(m);
        }
    }

    public void signUpButtonHandle() throws  IOException {
        //set scene to sign up screen
        Parent root = FXMLLoader.load(getClass().getResource("signUp.fxml"));
        Stage m = Main.getMainStage();
        Scene t = new Scene(root, 600, 600);
        t.setRoot(root);
        m.setScene(t);
        Main.setMainStage(m);
    }

}
