package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import sample.*;


import java.io.IOException;

public class LoadGameController{

    Game game = Game.getInstance();

    @FXML
    public Button backButton;
    @FXML
    ImageView levelOneButton, backView, levelTwoButton, levelThreeButton, levelFourButton, levelFiveButton, levelSixButton, levelSevenButton, levelEightButton, levelNineButton, levelTenButton;

    private ImageView[] buttons;
    private int levelCount;


    @FXML
    public void initialize(){
        Image[] unlockImages = new Image[10];
        unlockImages[0] = new Image("file:images/loadgame/levelOne.png");
        unlockImages[1] = new Image("file:images/loadgame/levelTwo.png");
        unlockImages[2] = new Image("file:images/loadgame/levelThree.png");
        unlockImages[3] = new Image("file:images/loadgame/levelFour.png");
        unlockImages[4] = new Image("file:images/loadgame/levelFive.png");
        unlockImages[5] = new Image("file:images/loadgame/levelSix.png");
        unlockImages[6] = new Image("file:images/loadgame/levelSeven.png");
        unlockImages[7] = new Image("file:images/loadgame/levelEight.png");
        unlockImages[8] = new Image("file:images/loadgame/levelNine.png");
        unlockImages[9] = new Image("file:images/loadgame/levelTen.png");


        buttons = new ImageView[10];
        buttons[0] = levelOneButton;
        buttons[1] = levelTwoButton;
        buttons[2] = levelThreeButton;
        buttons[3] = levelFourButton;
        buttons[4] = levelFiveButton;
        buttons[5] = levelSixButton;
        buttons[6] = levelSevenButton;
        buttons[7] = levelEightButton;
        buttons[8] = levelNineButton;
        buttons[9] = levelTenButton;


        levelCount = game.user.getLastPassedLevel();

        for(int m = 0; m < levelCount; m++){
            buttons[m].setImage(unlockImages[m]);
        }
    }


    public void levelOneClick() throws IOException{
            game.setCurrent2DLevel(0);
            Stage primaryStage = Main.getMainStage();

            AdditionModel model = new AdditionModel();
            AdditionController controller = new AdditionController(model);
            AdditionView view = new AdditionView(controller, model);

            Scene scene = new Scene(view.asParent(), 1500, 1000);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
            primaryStage.show();
            Main.setMainStage(primaryStage);
    }

    public void levelTwoClick() throws IOException{

        if (levelCount > 0) {
            game.setCurrent2DLevel(1);
            Stage primaryStage = Main.getMainStage();

            AdditionModel model = new AdditionModel();
            AdditionController controller = new AdditionController(model);
            AdditionView view = new AdditionView(controller, model);

            Scene scene = new Scene(view.asParent(), 1500, 1000);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
            primaryStage.show();
            Main.setMainStage(primaryStage);
        }
    }
    public void levelThreeClick() throws IOException{

        if (levelCount > 1) {
            game.setCurrent2DLevel(2);
            Stage primaryStage = Main.getMainStage();

            AdditionModel model = new AdditionModel();
            AdditionController controller = new AdditionController(model);
            AdditionView view = new AdditionView(controller, model);

            Scene scene = new Scene(view.asParent(), 1500, 1000);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
            primaryStage.show();
            Main.setMainStage(primaryStage);
        }

    }
    public void levelFourClick() throws IOException{

        if (levelCount > 2) {
            game.setCurrent2DLevel(3);
            Stage primaryStage = Main.getMainStage();

            AdditionModel model = new AdditionModel();
            AdditionController controller = new AdditionController(model);
            AdditionView view = new AdditionView(controller, model);

            Scene scene = new Scene(view.asParent(), 1500, 1000);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
            primaryStage.show();
            Main.setMainStage(primaryStage);
        }

    }
    public void levelFiveClick() throws IOException{
        if (levelCount > 3) {
            game.setCurrent2DLevel(4);
            Stage primaryStage = Main.getMainStage();

            AdditionModel model = new AdditionModel();
            AdditionController controller = new AdditionController(model);
            AdditionView view = new AdditionView(controller, model);

            Scene scene = new Scene(view.asParent(), 1500, 1000);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
            primaryStage.show();
            Main.setMainStage(primaryStage);
        }

    }
    public void levelSixClick() throws IOException{
        if (levelCount > 4) {
            game.setCurrent2DLevel(5);
            Stage primaryStage = Main.getMainStage();

            AdditionModel model = new AdditionModel();
            AdditionController controller = new AdditionController(model);
            AdditionView view = new AdditionView(controller, model);

            Scene scene = new Scene(view.asParent(), 1500, 1000);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
            primaryStage.show();
            Main.setMainStage(primaryStage);
        }

    }
    public void levelSevenClick() throws IOException{
        if (levelCount > 5) {
            game.setCurrent2DLevel(6);
            Stage primaryStage = Main.getMainStage();

            AdditionModel model = new AdditionModel();
            AdditionController controller = new AdditionController(model);
            AdditionView view = new AdditionView(controller, model);

            Scene scene = new Scene(view.asParent(), 1500, 1000);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
            primaryStage.show();
            Main.setMainStage(primaryStage);
        }

    }
    public void levelEightClick() throws IOException{
        if (levelCount > 6) {
            game.setCurrent2DLevel(7);
            Stage primaryStage = Main.getMainStage();

            AdditionModel model = new AdditionModel();
            AdditionController controller = new AdditionController(model);
            AdditionView view = new AdditionView(controller, model);

            Scene scene = new Scene(view.asParent(), 1500, 1000);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
            primaryStage.show();
            Main.setMainStage(primaryStage);
        }

    }
    public void levelNineClick() throws IOException{
        if (levelCount > 7) {
            game.setCurrent2DLevel(8);
            Stage primaryStage = Main.getMainStage();

            AdditionModel model = new AdditionModel();
            AdditionController controller = new AdditionController(model);
            AdditionView view = new AdditionView(controller, model);

            Scene scene = new Scene(view.asParent(), 1500, 1000);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
            primaryStage.show();
            Main.setMainStage(primaryStage);
        }

    }
    public void levelTenClick() throws IOException{
        if (levelCount > 8) {
            game.setCurrent2DLevel(9);
            Stage primaryStage = Main.getMainStage();

            AdditionModel model = new AdditionModel();
            AdditionController controller = new AdditionController(model);
            AdditionView view = new AdditionView(controller, model);

            Scene scene = new Scene(view.asParent(), 1500, 1000);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
            primaryStage.show();
            Main.setMainStage(primaryStage);
        }

    }

    public void backButtonHandle() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        Stage m = Main.getMainStage();
        Scene t = Main.getMainStage().getScene();
        t.setRoot(root);
        m.setScene(t);
        Main.setMainStage(m);
    }

    public void refreshLevels() throws IOException{
        int i = game.getLastPassed2d();

        for (int m = 0; m < i; m++){
            //buttons[i].setImage()
        }
    }
}