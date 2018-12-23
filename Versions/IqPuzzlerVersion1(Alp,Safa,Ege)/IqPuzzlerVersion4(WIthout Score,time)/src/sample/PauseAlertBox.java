package sample;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.io.IOException;


public class PauseAlertBox {

    public Button resumeButton;
    public Button replayButton;
    public Button exitButton;

    Stage window;

    public void display() throws IOException {
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Pause");

        Parent root = FXMLLoader.load(getClass().getResource("PauseAlertBox.fxml"));

        Scene scene = new Scene(root);
        window.setScene(scene);
        window.showAndWait();

    }

    public void resumeButtonHandle() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("NewGame.fxml"));
        Stage m = Main.getMainStage();
        Scene t = Main.getMainStage().getScene();
        t.setRoot(root);
        m.setScene(t);
        Main.setMainStage(m);
    }

    public void replayButtonHandle() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("NewGame.fxml"));
        Stage m = Main.getMainStage();
        Scene t = Main.getMainStage().getScene();
        t.setRoot(root);
        m.setScene(t);
        Main.setMainStage(m);
    }

    public void exitButtonHandle() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        Stage m = Main.getMainStage();
        Scene t = Main.getMainStage().getScene();
        t.setRoot(root);
        m.setScene(t);
        Main.setMainStage(m);
    }



//    Stage m = Main.getMainStage();
//    Scene t = Main.getMainStage().getScene();
//        t.setRoot(root);
//        m.setScene(t);
//        Main.setMainStage(m);

}
