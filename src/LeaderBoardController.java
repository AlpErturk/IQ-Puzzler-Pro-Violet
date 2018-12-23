package sample;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class LeaderBoardController {

    public Button backButton;
    ImageView backView;


    private DatabaseManager database;
    private User[] userArray;

    @FXML
    Label firstUsername, secondUsername, thirdUsername, fourthUsername, firstScore, secondScore, thirdScore, fourthScore;

    @FXML
    public void initialize(){

        database = new DatabaseManager();
        userArray = new User [100];

        fillLeaderBoard();
        sortUsers();

        firstUsername.setText(userArray[0].getUsername());
        secondUsername.setText(userArray[1].getUsername());
        thirdUsername.setText(userArray[2].getUsername());
        fourthUsername.setText(userArray[3].getUsername());

        firstScore.setText(userArray[0].getScore() + "");
        secondScore.setText(userArray[1].getScore() + "");
        thirdScore.setText(userArray[2].getScore() + "");
        fourthScore.setText(userArray[3].getScore() + "");


    }

    public void fillLeaderBoard(){
        database.fillLeaderBoard(userArray);
    }

    public void printLeaderBoard(){
        System.out.println("USERNAME" + "     " + "SCORE");
        for(int i = 0; i < 100; i++){
            if(userArray[i] != null) {
                System.out.println(userArray[i].getUsername() + "     " + userArray[i].getScore());
            }
        }
    }

    public void sortUsers(){
        //selection sort
        int size = 0;
        for(int i = 0; i < 100; i++){
            if(userArray[i] != null){
                size++;
            }
        }

        System.out.println(size);

        //now we know the actual size of array
        for(int i = 0; i < size-1; i++){
            int max_id = i;
            for(int j = i+1; j < size; j++){
                if(userArray[j].getScore() > userArray[max_id].getScore()){
                    max_id = j;
                }
            }

            User temp = userArray[max_id];
            userArray[max_id] = userArray[i];
            userArray[i] = temp;
        }
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