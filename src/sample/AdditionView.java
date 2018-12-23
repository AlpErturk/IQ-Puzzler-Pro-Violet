package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import jfxtras.labs.util.event.MouseControlUtil;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class AdditionView {

    private BorderPane backgroundPane;
    private BorderPane menuPane;
    private int timerPosition;
    private int levelTime;
    private int time;
    int hammerClickCount = 0;
    int iceBreakClickCount = 0;
    boolean hammerButtonClicked = false;


    private AdditionController controller;
    private AdditionModel model ;
    private GameField field;

    ImageView boardView;
    Scene currentScene = Main.getMainStage().getScene();


    public AdditionView(AdditionController controller, AdditionModel model) {

        this.controller = controller ;
        this.model = model ;

        createAndConfigurePane();
        createAndLayoutControls();

        levelTime = model.getLevelTime();
        time = 0;

        field = new GameField(model.game.twoDLevels[model.game.getCurrent2DLevel()]);

    }

    public Parent asParent() {
        return backgroundPane ;
    }


    private void updateIfNeeded(Number value, TextField field) {
        String s = value.toString() ;
        if (! field.getText().equals(s)) {
            field.setText(s);
        }
    }


    private void createAndLayoutControls() {
    }

    private void createAndConfigurePane() {

        backgroundPane = new BorderPane();
        menuPane = new BorderPane();
        menuPane.setPadding(new Insets(10, 20 ,10 ,20));

        menuPane.setMinSize(150,150);
        menuPane.setMaxSize(150, 150);

        Button pauseButton = new Button("Pause");
        pauseButton.setOnAction(controller.handler);
        Button ege = new Button("Ege");

        //Hammer button
        Button hammerButton = new Button();
        hammerButton.setGraphic(new ImageView("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/hammer.png"));
        //menuPane.getChildren().addAll(hammerButton);
        menuPane.setTop(hammerButton);
        hammerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Image hammerImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/hammer.png");
                ImageCursor cursor = new ImageCursor(hammerImage, 0, 0);
                backgroundPane.setCursor(cursor);
                hammerButtonClicked = true;
            }
        });

        menuPane.getChildren().addAll(ege);
        menuPane.getChildren().addAll(pauseButton);

        ege.setLayoutX(50);
        ege.setLayoutY(60);
        pauseButton.setLayoutX(50);
        pauseButton.setLayoutY(20);

        Pane pieceBox = new Pane();
        pieceBox.setMinHeight(model.sceneHeight - menuPane.getHeight());
        pieceBox.setMinWidth(model.sceneWidth);

        Image timerImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/menu/progress.png");
        ImageView timerView = new ImageView(timerImage);
        Image lineImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/menu/theLine.png");
        ImageView lineView = new ImageView(lineImage);

        menuPane.getChildren().addAll(lineView);
        menuPane.getChildren().addAll(timerView);

        lineView.setLayoutY(60);

        int timerStartingX = (model.getSceneWidth() - 660) / 2;

        lineView.setLayoutX(timerStartingX);
        timerView.setLayoutY(55);
        timerView.setLayoutX(timerStartingX);
        timerPosition = timerStartingX;

        Timer timer = new Timer();
        Timer iceTimer = new Timer();
        Timer giftTimer = new Timer();
        Timer deleteGiftTimer = new Timer();
        ArrayList<ImageView> iceBlocks = new ArrayList<>();
        ArrayList<ImageView> gifts = new ArrayList<>();

        TimerTask task = new TimerTask()
        {
           /* public void run()
            {
                time++;
                timerView.setLayoutX(timerPosition += 2);

                if(timerPosition > model.getSceneWidth())
                    timerPosition  = timerStartingX;

                if(time == levelTime){
                    timer.cancel();
                }

            }*/

           public void run()
             {
                timerView.setLayoutX(timerPosition+=10);
                if(timerPosition > model.sceneWidth)
                   timerPosition  = 0;
            }
        };

        TimerTask giftTask = new TimerTask(){
            @Override
            public  void  run(){
                Platform.runLater(() ->{
                    ArrayList<Integer> emptyRowPositions = new ArrayList<>();
                    ArrayList<Integer> emptyColumnPositions = new ArrayList<>();
                    for(int i = 0; i < 5; i++){ //find empy positions
                        for(int j = 0; j < 11; j++){
                            if(model.getBoard().boardMatrix[i][j] == 0){
                                emptyRowPositions.add(i);
                                emptyColumnPositions.add(j);
                            }
                        }
                    }
                    int randomRow1, randomColumn;
                    if(gifts.size() == 0){
                        randomRow1 = (int)(Math.random() * emptyRowPositions.size());
                        randomColumn = randomRow1;
                        Image gift = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/gift.png");
                        ImageView giftView = new ImageView(gift);
                        giftView.setFitHeight(70);
                        giftView.setFitWidth(70);
                        pieceBox.getChildren().addAll(giftView);
                        giftView.relocate(model.getXboardMatrix()[emptyRowPositions.get(randomRow1)][emptyColumnPositions.get(randomColumn)], model.getYboardMatrix()[emptyRowPositions.get(randomRow1)][emptyColumnPositions.get(randomColumn)]);
                        gifts.add(giftView);
                        model.getBoard().boardMatrix[emptyRowPositions.get(randomRow1)][emptyColumnPositions.get(randomColumn)] = -2;
                    }
                });
            }
        };

        TimerTask deleteGiftTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{
                    ArrayList<Integer> giftPositionRow = new ArrayList<Integer>();
                    ArrayList<Integer> giftPositionColumn = new ArrayList<Integer>();
                    for(int i = 0; i < 5; i++){
                        for(int j = 0; j < 11; j++){
                            if(model.getBoard().boardMatrix[i][j] == -2){
                                giftPositionColumn.add(j);
                                giftPositionRow.add(i);
                            }
                        }
                    }
                    if(gifts.isEmpty() == false){
                        gifts.get(0).setImage(null);
                        gifts.remove(0);
                        model.getBoard().boardMatrix[giftPositionRow.get(0)][giftPositionColumn.get(0)] = 0;
                    }
                });
            }
        };


        TimerTask iceTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() ->{
                    ArrayList<Integer> emptyRowPositions = new ArrayList<>();
                    ArrayList<Integer> emptyColumnPositions = new ArrayList<>();
                    for(int i = 0; i < 5; i++){ //find empy positions
                        for(int j = 0; j < 11; j++){
                            if(model.getBoard().boardMatrix[i][j] == 0){
                                emptyRowPositions.add(i);
                                emptyColumnPositions.add(j);
                            }
                        }
                    }
                    //choose random empty positions
                    int randomRow1, randomRow2, randomRow3, randomColumn1, randomColumn2, randomColumn3;
                    if(emptyRowPositions.size() >= 3){
                        do{
                            randomRow1 = (int)(Math.random() * emptyRowPositions.size());
                            randomRow2 = (int)(Math.random() * emptyRowPositions.size());
                            randomRow3 = (int)(Math.random() * emptyRowPositions.size());
                            if(randomRow1 != randomRow2 && randomRow1 != randomRow3 && randomRow2 != randomRow3){
                                randomColumn1 = randomRow1;
                                randomColumn2 = randomRow2;
                                randomColumn3 = randomRow3;

                                Image ice = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/ice.png");
                                Image ice2 = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/ice2.png");
                                Image ice3 = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/ice3.png");

                                ImageView ice1View = new ImageView(ice);
                                ImageView ice2View = new ImageView(ice2);
                                ImageView ice3View = new ImageView(ice3);

                                ice1View.setFitHeight(70);
                                ice1View.setFitWidth(70);
                                ice2View.setFitHeight(70);
                                ice2View.setFitWidth(70);
                                ice3View.setFitHeight(70);
                                ice3View.setFitWidth(70);

                                pieceBox.getChildren().add(ice1View);
                                pieceBox.getChildren().add(ice2View);
                                pieceBox.getChildren().add(ice3View);

                                ice1View.relocate(model.getXboardMatrix()[emptyRowPositions.get(randomRow1)][emptyColumnPositions.get(randomColumn1)], model.getYboardMatrix()[emptyRowPositions.get(randomRow1)][emptyColumnPositions.get(randomColumn1)]);
                                ice2View.relocate(model.getXboardMatrix()[emptyRowPositions.get(randomRow2)][emptyColumnPositions.get(randomColumn2)], model.getYboardMatrix()[emptyRowPositions.get(randomRow2)][emptyColumnPositions.get(randomColumn2)]);
                                ice3View.relocate(model.getXboardMatrix()[emptyRowPositions.get(randomRow3)][emptyColumnPositions.get(randomColumn3)], model.getYboardMatrix()[emptyRowPositions.get(randomRow3)][emptyColumnPositions.get(randomColumn3)]);

                                iceBlocks.add(ice1View);
                                iceBlocks.add(ice2View);
                                iceBlocks.add(ice3View);

                                model.getBoard().boardMatrix[emptyRowPositions.get(randomRow1)][emptyColumnPositions.get(randomColumn1)] = -1;
                                model.getBoard().boardMatrix[emptyRowPositions.get(randomRow2)][emptyColumnPositions.get(randomColumn2)] = -1;
                                model.getBoard().boardMatrix[emptyRowPositions.get(randomRow3)][emptyColumnPositions.get(randomColumn3)] = -1;

                                break;
                            }
                        }while(randomRow1 != randomRow2 && randomRow1 != randomRow3 && randomRow2 != randomRow3);
                    }
                });
            }
        };

        iceTimer.scheduleAtFixedRate(iceTask, 5000, 9000);
        giftTimer.scheduleAtFixedRate(giftTask, 6000, 7000);
        deleteGiftTimer.scheduleAtFixedRate(deleteGiftTask,0,10000);
        timer.scheduleAtFixedRate(task,1000,100);


        //model.getBoard().printBoardMatrix();
        //model.getBoard().updateBoard();
        ImageView boardView = model.game.twoDLevels[model.game.getCurrent2DLevel()].getBoardView();


        ArrayList<Piece> unUsuedPieces = model.game.twoDLevels[model.game.getCurrent2DLevel()].getUnusedPieces();
        //System.out.println( model.game.twoDLevels[model.game.getCurrent2DLevel()].getUnusedPieces().get(0).getPieceId());
        ArrayList<ImageView> unUsedPiecesView = new ArrayList<ImageView>();
        //model.board.updateBoard();

        //assign imageviews of pieces
        for(int i = 0; i < unUsuedPieces.size(); i++){
            unUsedPiecesView.add(i, unUsuedPieces.get(i).getCurrentImage());
            unUsedPiecesView.get(i).relocate(model.getxPositions()[i], model.getyPositions()[i]);
            pieceBox.getChildren().add(unUsedPiecesView.get(i));
            MouseControlUtil.makeDraggable(unUsuedPieces.get(i).getCurrentImage());
        }


        pieceBox.getChildren().add(boardView);
        boardView.setLayoutX((model.sceneWidth - model.board.getBoardWidth()) / 2 );
        boardView.setLayoutY(0);

//--------------------------------------------------------------------------------------------------
        backgroundPane.addEventFilter(KeyEvent.KEY_PRESSED, event->{
            if (event.getCode() == KeyCode.SPACE) {
                controller.getSelectedPiece().getCurrentImage().setRotate(controller.getSelectedPiece().getCurrentImage().getRotate()+90);
                controller.getSelectedPiece().rotateMatrixLeft();
                controller.getSelectedPiece().getCurrentImage().setFitWidth(280);
                controller.getSelectedPiece().getCurrentImage().setFitHeight(280);
                //controller.getSelectedPiece().getCurrentImage();
                //System.out.println("")
            }
        });


        //MIRROR VISUAL
        backgroundPane.addEventFilter(KeyEvent.KEY_PRESSED, event-> {
            if (event.getCode() == KeyCode.V && controller.getSelectedPiece().getCurrentImage().getScaleX() == 1) {
                //selectedPiece.getCurrentImage().setRotate(selectedPiece.getCurrentImage().getRotate() + 90);
                //System.out.println("")
                controller.getSelectedPiece().getCurrentImage().setScaleX(-1);
            }
            else if (event.getCode() == KeyCode.V && controller.getSelectedPiece().getCurrentImage().getScaleX() == -1) {
                controller.getSelectedPiece().getCurrentImage().setScaleX(1);
            }
        });

        backgroundPane.addEventFilter(KeyEvent.KEY_PRESSED, event-> {
            if (event.getCode() == KeyCode.H && controller.getSelectedPiece().getCurrentImage().getScaleY() == 1) {
                //selectedPiece.getCurrentImage().setRotate(selectedPiece.getCurrentImage().getRotate() + 90);
                //System.out.println("")
                controller.getSelectedPiece().getCurrentImage().setScaleY(-1);
            }
            else if (event.getCode() == KeyCode.H && controller.getSelectedPiece().getCurrentImage().getScaleY() == -1) {
                controller.getSelectedPiece().getCurrentImage().setScaleY(1);
            }

        });

        //HEDİYELERİ ALMA
        backgroundPane.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                double xClicked = mouseEvent.getX();
                double yClicked = mouseEvent.getY() - 150;

                double boardHeight = 350;
                double boardWidth = 770;
                double sceneWidth =  backgroundPane.getWidth();
                double sceneHeight =  backgroundPane.getHeight();
                double leftXCoordinate = (sceneWidth - boardWidth) / 2 ;
                double topYCoordinate = 0;
                double rightXCoordinate = leftXCoordinate + boardWidth;;
                double bottomYCoordinate = boardHeight + topYCoordinate;

                if(((xClicked > leftXCoordinate && xClicked < rightXCoordinate) && (yClicked > topYCoordinate && yClicked < bottomYCoordinate))){
                    int indexColumn = (int)((xClicked - leftXCoordinate) / 70);
                    int indexRow = (int)((yClicked - topYCoordinate) / 70);

                    if(model.getBoard().boardMatrix[indexRow][indexColumn] == -2){
                        gifts.get(0).setImage(null);
                        model.getBoard().boardMatrix[indexRow][indexColumn] = 0;
                        gifts.remove(0);
                    }
                }
            }
        });

        //BUZLARI KIRMA
         backgroundPane.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                hammerClickCount++;
                if(hammerButtonClicked){
                    if(hammerClickCount % 2 == 0){
                        Image hammerImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/hammer.png");
                        ImageCursor cursor = new ImageCursor(hammerImage, 0, 0);
                        backgroundPane.setCursor(cursor);
                    }

                    else{
                        Image hammerImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/hammer20.png");
                        ImageCursor cursor = new ImageCursor(hammerImage, 0, 0);
                        backgroundPane.setCursor(cursor);
                    }
                }

                double xClicked = mouseEvent.getX();
                double yClicked = mouseEvent.getY() - 150;

                double boardHeight = 350;
                double boardWidth = 770;
                double sceneWidth =  backgroundPane.getWidth();
                double sceneHeight =  backgroundPane.getHeight();
                double leftXCoordinate = (sceneWidth - boardWidth) / 2 ;
                double topYCoordinate = 0;
                double rightXCoordinate = leftXCoordinate + boardWidth;;
                double bottomYCoordinate = boardHeight + topYCoordinate;

                if(((xClicked > leftXCoordinate && xClicked < rightXCoordinate) && (yClicked > topYCoordinate &&yClicked < bottomYCoordinate)) && hammerButtonClicked){
                    int indexColumn = (int)((xClicked - leftXCoordinate) / 70);
                    int indexRow = (int)((yClicked - topYCoordinate) / 70);

                    if(model.getBoard().boardMatrix[indexRow][indexColumn] == -1){
                        iceBreakClickCount++;
                        for(int i = 0; i < iceBlocks.size(); i++){
                            if(iceBlocks.get(i).getLayoutX() == (model.getXboardMatrix()[indexRow][indexColumn]) && iceBlocks.get(i).getLayoutY() == model.getYboardMatrix()[indexRow][indexColumn] && iceBreakClickCount == 3){
                                iceBlocks.get(i).setImage(null);
                                model.getBoard().boardMatrix[indexRow][indexColumn] = 0;
                                iceBlocks.remove(i);
                                iceBreakClickCount = 0;
                            }
                        }
                    }
                }
                else{
                    iceBreakClickCount = 0;
                }
            }
        });


//--------------------------------------------------------------------------------------------------

        //Adding event handler to unused pieces in specific level
        for(int i = 0; i < model.game.twoDLevels[model.game.getCurrent2DLevel()].getUnusedPieces().size(); i++){
            model.game.twoDLevels[model.game.getCurrent2DLevel()].getUnusedPieces().get(i).getCurrentImage().addEventHandler(MouseEvent.MOUSE_RELEASED, controller.releaseHandler);
            model.game.twoDLevels[model.game.getCurrent2DLevel()].getUnusedPieces().get(i).getCurrentImage().addEventHandler(MouseEvent.MOUSE_PRESSED, controller.pressedHandler);
        }

        Image backgroundImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/menu/snowySecond.png");

        BackgroundImage myBI= new BackgroundImage(backgroundImage,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);


        backgroundPane.setBottom(pieceBox);
        backgroundPane.setTop(menuPane);
        backgroundPane.setBackground(new Background(myBI));
    }

}