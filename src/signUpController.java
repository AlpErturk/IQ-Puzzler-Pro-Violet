package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import sample.DatabaseManager;
import sample.Main;


import java.io.IOException;

public class signUpController {

    public Button backButton;
    public Button signUpButton;
    public TextField usernameField;
    public TextField passwordField;
    DatabaseManager database = new DatabaseManager();

    public void signUpButtonHandle(ActionEvent event) throws IOException{
        //if the sign up button is pressed
        String username = usernameField.getText();
        String password = passwordField.getText();

        if(username != "" && password != ""){
            //check if user present in database
            if(database.registerUser(username, password)){
                //register user is successful
                System.out.println("User sign up is successful");
                //identify user !!
                //go to main menu after successful sign up
                Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
                Stage m = Main.getMainStage();
                Scene t = new Scene(root);
                t.setRoot(root);
                m.setScene(t);
                Main.setMainStage(m);

            }

        }
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