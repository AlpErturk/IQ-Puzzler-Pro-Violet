package sample;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import java.io.IOException;

public class AdditionController {

    private final AdditionModel model ;

    Piece selectedPiece;


    public AdditionController(AdditionModel model) {
        this.model = model;
    }

    javafx.event.EventHandler handler = new javafx.event.EventHandler() {
        @Override
        public void handle(Event event) {
            Parent root = null;
            try {

                root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
                Stage m = Main.getMainStage();
                Scene t = new Scene(root);
                m.setScene(t);
                Main.setMainStage(m);
                m.centerOnScreen();

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }};


    javafx.event.EventHandler pressedHandler = new javafx.event.EventHandler() {
        @Override
        public void handle(Event event) {

            if (event.getSource() == model.game.pieceOne.getCurrentImage()) {
                selectedPiece = model.game.pieceOne;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.board.boardMatrix[i][j] == model.game.pieceOne.getPieceId()) {
                            model.board.boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() == model.game.pieceTwo.getCurrentImage()) {
                selectedPiece = model.game.pieceTwo;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.board.boardMatrix[i][j] == model.game.pieceTwo.getPieceId()) {
                            model.board.boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() == model.game.pieceThree.getCurrentImage()) {
                selectedPiece = model.game.pieceThree;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.board.boardMatrix[i][j] == model.game.pieceThree.getPieceId()) {
                            model.board.boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() == model.game.pieceFour.getCurrentImage()) {
                selectedPiece = model.game.pieceFour;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.board.boardMatrix[i][j] == model.game.pieceFour.getPieceId()) {
                            model.board.boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() ==  model.game.pieceFive.getCurrentImage()) {
                selectedPiece = model.game.pieceFive;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.board.boardMatrix[i][j] ==  model.game.pieceFive.getPieceId()) {
                            model.board.boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() ==  model.game.pieceSix.getCurrentImage()) {
                selectedPiece =  model.game.pieceSix;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.board.boardMatrix[i][j] ==  model.game.pieceSix.getPieceId()) {
                            model.board.boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() == model.game.pieceSeven.getCurrentImage()) {
                selectedPiece = model.game.pieceSeven;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.board.boardMatrix[i][j] == model.game.pieceSeven.getPieceId()) {
                            model.board.boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() == model.game.pieceEight.getCurrentImage()) {
                selectedPiece = model.game.pieceEight;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.board.boardMatrix[i][j] == model.game.pieceEight.getPieceId()) {
                            model.board.boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() == model.game.pieceNine.getCurrentImage()) {
                selectedPiece = model.game.pieceNine;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.board.boardMatrix[i][j] == model.game.pieceNine.getPieceId()) {
                            model.board.boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() == model.game.pieceTen.getCurrentImage()) {
                selectedPiece = model.game.pieceTen;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.board.boardMatrix[i][j] == model.game.pieceTen.getPieceId()) {
                            model.board.boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() ==  model.game.pieceEleven.getCurrentImage()) {
                selectedPiece =  model.game.pieceEleven;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.board.boardMatrix[i][j] ==  model.game.pieceEleven.getPieceId()) {
                            model.board.boardMatrix[i][j] = 0;
                        }
                    }
                }
            } else if (event.getSource() ==  model.game.pieceTwelve.getCurrentImage()) {
                selectedPiece =  model.game.pieceTwelve;
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.board.boardMatrix[i][j] ==  model.game.pieceTwelve.getPieceId()) {
                            model.board.boardMatrix[i][j] = 0;
                        }
                    }
                }
            }
        }};



    //--------------------------------------------------------------------------------------------------

    //MOUSE RELEASED EVENT HANDLER
    //This code calculates the position of piece


    javafx.event.EventHandler releaseHandler = new javafx.event.EventHandler() {
        @Override
        public void handle(Event event){

            if(event.getSource() == model.game.pieceOne.getCurrentImage()) {
                System.out.println("Layout X10: " +model.game.pieceOne.getCurrentImage().getLayoutX());
                System.out.println("Layout Y10: " +model.game.pieceOne.getCurrentImage().getLayoutY());
                if (model.board.checkPieceBoundary(model.getGame().pieceTen.getCurrentImage(), 40, 440)) {
                    model.board.putPiece(model.game.pieceOne, model.getXboardMatrix(), model.getYboardMatrix(), 40, 440);
                }
            }

            if(event.getSource() == model.game.pieceTwo.getCurrentImage()) {
                System.out.println("Layout X10: " +model.game.pieceTwo.getCurrentImage().getLayoutX());
                System.out.println("Layout Y10: " +model.game.pieceTwo.getCurrentImage().getLayoutY());
                if (model.board.checkPieceBoundary(model.getGame().pieceTwo.getCurrentImage(), 40, 440)) {
                    model.board.putPiece(model.game.pieceTwo, model.getXboardMatrix(), model.getYboardMatrix(), 40, 440);
                }
            }

            if(event.getSource() == model.game.pieceThree.getCurrentImage()) {
                System.out.println("Layout X10: " +model.game.pieceThree.getCurrentImage().getLayoutX());
                System.out.println("Layout Y10: " +model.game.pieceThree.getCurrentImage().getLayoutY());
                if (model.board.checkPieceBoundary(model.getGame().pieceThree.getCurrentImage(), 40, 440)) {
                    model.board.putPiece(model.game.pieceThree, model.getXboardMatrix(), model.getYboardMatrix(), 40, 440);
                }
            }

            if(event.getSource() == model.game.pieceFour.getCurrentImage()) {
                System.out.println("Layout X10: " +model.game.pieceFour.getCurrentImage().getLayoutX());
                System.out.println("Layout Y10: " +model.game.pieceFour.getCurrentImage().getLayoutY());
                if (model.board.checkPieceBoundary(model.getGame().pieceFour.getCurrentImage(), 40, 440)) {
                    model.board.putPiece(model.game.pieceFour, model.getXboardMatrix(), model.getYboardMatrix(), 40, 440);
                }
            }

            if(event.getSource() == model.game.pieceFive.getCurrentImage()) {
                System.out.println("Layout X10: " +model.game.pieceFive.getCurrentImage().getLayoutX());
                System.out.println("Layout Y10: " +model.game.pieceFive.getCurrentImage().getLayoutY());
                if (model.board.checkPieceBoundary(model.getGame().pieceFive.getCurrentImage(), 280, 440)) {
                    model.board.putPiece(model.game.pieceFive, model.getXboardMatrix(), model.getYboardMatrix(), 280, 440);
                }
            }

            if(event.getSource() == model.game.pieceSix.getCurrentImage()) {
                System.out.println("Layout X10: " +model.game.pieceSix.getCurrentImage().getLayoutX());
                System.out.println("Layout Y10: " +model.game.pieceSix.getCurrentImage().getLayoutY());
                if (model.board.checkPieceBoundary(model.getGame().pieceSix.getCurrentImage(), 570, 440)) {
                    model.board.putPiece(model.game.pieceSix, model.getXboardMatrix(), model.getYboardMatrix(), 570, 440);

                }
            }

            if(event.getSource() == model.game.pieceSeven.getCurrentImage()) {
                System.out.println("Layout X10: " +model.game.pieceSeven.getCurrentImage().getLayoutX());
                System.out.println("Layout Y10: " +model.game.pieceSeven.getCurrentImage().getLayoutY());
                if (model.board.checkPieceBoundary(model.getGame().pieceSeven.getCurrentImage(), 570, 440)) {
                    model.board.putPiece(model.game.pieceSeven, model.getXboardMatrix(), model.getYboardMatrix(), 570, 440);

                }
            }

            if(event.getSource() == model.game.pieceEight.getCurrentImage()) {
                System.out.println("Layout X10: " +model.game.pieceEight.getCurrentImage().getLayoutX());
                System.out.println("Layout Y10: " +model.game.pieceEight.getCurrentImage().getLayoutY());
                if (model.board.checkPieceBoundary(model.getGame().pieceEight.getCurrentImage(), 570, 440)) {
                    model.board.putPiece(model.game.pieceEight, model.getXboardMatrix(), model.getYboardMatrix(), 570, 440);

                }
            }

            if(event.getSource() == model.game.pieceNine.getCurrentImage()) {
                System.out.println("Layout X10: " +model.game.pieceNine.getCurrentImage().getLayoutX());
                System.out.println("Layout Y10: " +model.game.pieceNine.getCurrentImage().getLayoutY());
                if (model.board.checkPieceBoundary(model.getGame().pieceNine.getCurrentImage(), 570, 440)) {
                    model.board.putPiece(model.game.pieceNine, model.getXboardMatrix(), model.getYboardMatrix(), 570, 440);

                }
            }

            if(event.getSource() == model.game.pieceTen.getCurrentImage()) {
                System.out.println("Layout X10: " +model.game.pieceTen.getCurrentImage().getLayoutX());
                System.out.println("Layout Y10: " +model.game.pieceTen.getCurrentImage().getLayoutY());
                if (model.board.checkPieceBoundary(model.getGame().pieceTen.getCurrentImage(), 40, 440)) {
                    model.board.putPiece(model.game.pieceTen, model.getXboardMatrix(), model.getYboardMatrix(), 40, 440);

                }
            }

            else if(event.getSource() == model.game.pieceEleven.getCurrentImage()) {
                System.out.println("Layout X11: " +model.game.pieceEleven.getCurrentImage().getLayoutX());
                System.out.println("Layout Y11: " +model.game.pieceEleven.getCurrentImage().getLayoutY());
                if (model.board.checkPieceBoundary( model.getGame().pieceEleven.getCurrentImage(), 280, 440)) {
                    model.board.putPiece(model.game.pieceEleven, model.getXboardMatrix(), model.getYboardMatrix(), 280, 440);

                }
            }

            else if(event.getSource() == model.game.pieceTwelve.getCurrentImage()) {
                System.out.println("Layout X12: " +model.game.pieceTwelve.getCurrentImage().getLayoutX());
                System.out.println("Layout Y12: " +model.game.pieceTwelve.getCurrentImage().getLayoutY());
                if (model.board.checkPieceBoundary(model.getGame().pieceTwelve.getCurrentImage(), 570, 440)) {
                    model.board.putPiece(model.game.pieceTwelve, model.getXboardMatrix(), model.getYboardMatrix(), 570, 440);

                }
            }

        }};

    public Piece getSelectedPiece(){
        return selectedPiece;
    }


}