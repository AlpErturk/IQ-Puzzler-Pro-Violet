package sample;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class LeaderBoardController {

    public Button backButton;

    private DatabaseManager database = new DatabaseManager();
    private User[] userArray = new User [100];


    public void fillLeaderBoard(){
        database.fillLeaderBoard(userArray);
    }

    public void printLeaderBoard(){
        fillLeaderBoard();
        System.out.println("USERNAME" + "     " + "SCORE");
        for(int i = 0; i < 100; i++){
            if(userArray[i] != null) {
                System.out.println(userArray[i].getUsername() + "     " + userArray[i].getScore());
            }
        }
    }

    public ObservableList<User> getUsers(){
        ObservableList<User> users = FXCollections.observableArrayList();
        for(int i = 0; i < 100; i++){
            if(userArray[i] != null) {
                users.add(userArray[i]);
            }
        }
        return users;
    }

    public void backButtonHandle() throws IOException {

        printLeaderBoard();

        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        Stage m = Main.getMainStage();
        Scene t = Main.getMainStage().getScene();
        t.setRoot(root);
        m.setScene(t);
        Main.setMainStage(m);
    }
}