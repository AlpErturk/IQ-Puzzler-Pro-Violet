package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import sample.Main;


import javax.swing.text.html.ImageView;
import java.io.IOException;

public class mainMenuController {
     public Button newGameButton, loadGameButton, leaderBoardButton, tutorialButton, backButton;
     ImageView PlayView, LoadView, tutorialView, LeaderView, backView;

    public void newGameButtonHandle() throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("NewGame.fxml"));
        Stage m = Main.getMainStage();
        Scene t = Main.getMainStage().getScene();
        t.setRoot(root);
        m.setScene(t);
        Main.setMainStage(m);
    }

    public void loadGameButtonHandle() throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("LoadGame.fxml"));
        Stage m = Main.getMainStage();
        Scene t = Main.getMainStage().getScene();
        t.setRoot(root);
        m.setScene(t);
        Main.setMainStage(m);

    }

    public void leaderBoardButtonHandle() throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("LeaderBoard.fxml"));
        Stage m = Main.getMainStage();
        Scene t = Main.getMainStage().getScene();
        t.setRoot(root);
        m.setScene(t);
        Main.setMainStage(m);
    }

    public void backButtonHandle() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("logInScreen.fxml"));
        Stage m = Main.getMainStage();
        Scene t = Main.getMainStage().getScene();
        t.setRoot(root);
        m.setScene(t);
        Main.setMainStage(m);
    }


    public void tutorialButtonHandle() throws  IOException{
        //DISPLAY TUTORIAL IMAGES OR VIDEO
        Parent root = FXMLLoader.load(getClass().getResource("TutorialScreen.fxml"));
        Stage m = Main.getMainStage();
        Scene t = Main.getMainStage().getScene();
        t.setRoot(root);
        m.setScene(t);
        Main.setMainStage(m);

    }

}
