package sample;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
            try {
                Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
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


            if (event.getSource() == model.getGame().pieceOne.getCurrentImage()) {
                selectedPiece = model.getGame().pieceOne;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.getBoard().boardMatrix[i][j] == model.getGame().pieceOne.getPieceId()) {
                            model.getBoard().boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() == model.getGame().pieceTwo.getCurrentImage()) {
                selectedPiece = model.getGame().pieceTwo;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.getBoard().boardMatrix[i][j] == model.getGame().pieceTwo.getPieceId()) {
                            model.getBoard().boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() == model.getGame().pieceThree.getCurrentImage()) {
                selectedPiece = model.getGame().pieceThree;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.getBoard().boardMatrix[i][j] == model.getGame().pieceThree.getPieceId()) {
                            model.getBoard().boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() == model.getGame().pieceThreeVersion2.getCurrentImage()) {
                selectedPiece = model.getGame().pieceThreeVersion2;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.getBoard().boardMatrix[i][j] == model.getGame().pieceThreeVersion2.getPieceId()) {
                            model.getBoard().boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() == model.getGame().pieceFour.getCurrentImage()) {
                selectedPiece = model.getGame().pieceFour;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.getBoard().boardMatrix[i][j] == model.getGame().pieceFour.getPieceId()) {
                            model.getBoard().boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() ==  model.getGame().pieceFive.getCurrentImage()) {
                selectedPiece = model.getGame().pieceFive;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.getBoard().boardMatrix[i][j] ==  model.getGame().pieceFive.getPieceId()) {
                            model.getBoard().boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() ==  model.getGame().pieceSix.getCurrentImage()) {
                selectedPiece =  model.getGame().pieceSix;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.getBoard().boardMatrix[i][j] ==  model.getGame().pieceSix.getPieceId()) {
                            model.getBoard().boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() ==  model.getGame().pieceSixVersion2.getCurrentImage()) {
                selectedPiece =  model.getGame().pieceSixVersion2;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.getBoard().boardMatrix[i][j] ==  model.getGame().pieceSixVersion2.getPieceId()) {
                            model.getBoard().boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() == model.getGame().pieceSeven.getCurrentImage()) {
                selectedPiece = model.getGame().pieceSeven;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.getBoard().boardMatrix[i][j] == model.getGame().pieceSeven.getPieceId()) {
                            model.getBoard().boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() == model.getGame().pieceEight.getCurrentImage()) {
                selectedPiece = model.getGame().pieceEight;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.getBoard().boardMatrix[i][j] == model.getGame().pieceEight.getPieceId()) {
                            model.getBoard().boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() == model.getGame().pieceNine.getCurrentImage()) {
                selectedPiece = model.getGame().pieceNine;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.getBoard().boardMatrix[i][j] == model.getGame().pieceNine.getPieceId()) {
                            model.getBoard().boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() == model.getGame().pieceTen.getCurrentImage()) {
                selectedPiece = model.getGame().pieceTen;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.getBoard().boardMatrix[i][j] == model.getGame().pieceTen.getPieceId()) {
                            model.getBoard().boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() == model.getGame().pieceTenVersion2.getCurrentImage()) {
                selectedPiece = model.getGame().pieceTenVersion2;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.getBoard().boardMatrix[i][j] == model.getGame().pieceTenVersion2.getPieceId()) {
                            model.getBoard().boardMatrix[i][j] = 0;
                        }
                    }
                }
            }

            else if (event.getSource() ==  model.getGame().pieceEleven.getCurrentImage()) {
                selectedPiece =  model.getGame().pieceEleven;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.getBoard().boardMatrix[i][j] ==  model.getGame().pieceEleven.getPieceId()) {
                            model.getBoard().boardMatrix[i][j] = 0;
                        }
                    }
                }
            } else if (event.getSource() ==  model.getGame().pieceTwelve.getCurrentImage()) {
                selectedPiece =  model.getGame().pieceTwelve;
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.getBoard().boardMatrix[i][j] ==  model.getGame().pieceTwelve.getPieceId()) {
                            model.getBoard().boardMatrix[i][j] = 0;
                        }
                    }
                }
            }else if (event.getSource() ==  model.getGame().pieceTwelve2.getCurrentImage()) {
                selectedPiece =  model.getGame().pieceTwelve2;
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.getBoard().boardMatrix[i][j] ==  model.getGame().pieceTwelve2.getPieceId()) {
                            model.getBoard().boardMatrix[i][j] = 0;
                        }
                    }
                }
            }else if (event.getSource() ==  model.getGame().pieceEleven2.getCurrentImage()) {
                selectedPiece =  model.getGame().pieceEleven2;
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.getBoard().boardMatrix[i][j] ==  model.getGame().pieceEleven2.getPieceId()) {
                            model.getBoard().boardMatrix[i][j] = 0;
                        }
                    }
                }
            }else if (event.getSource() ==  model.getGame().pieceTwo2.getCurrentImage()) {
                selectedPiece =  model.getGame().pieceTwo2;
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 11; j++) {
                        if (model.getBoard().boardMatrix[i][j] ==  model.getGame().pieceTwo2.getPieceId()) {
                            model.getBoard().boardMatrix[i][j] = 0;
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
/*
            ArrayList<Piece> unUsuedPieces = model.getGame().twoDLevels[model.getGame().getCurrent2DLevel()].getUnusedPieces();
            for(int i = 0; i < unUsuedPieces.size(); i++){
                if(event.getSource() == unUsuedPieces.get(i)) {
                    if (model.getBoard().checkPieceBoundary(unUsuedPieces.get(i).getCurrentImage(), 40, 440)) {
                        model.getBoard().putPiece(unUsuedPieces.get(i), model.getXboardMatrix(), model.getYboardMatrix(), 40, 440);
                    }
                }
            }
            */

            if(event.getSource() == model.getGame().pieceOne.getCurrentImage()) {
                if (model.getBoard().checkPieceBoundary(model.getGame().pieceOne.getCurrentImage(), 40, 440)) {
                    model.getBoard().putPiece(model.getGame().pieceOne, model.getXboardMatrix(), model.getYboardMatrix(), 40, 440);
                }
            }

            if(event.getSource() == model.getGame().pieceTwo.getCurrentImage()) {
                if (model.getBoard().checkPieceBoundary(model.getGame().pieceTwo.getCurrentImage(), 40, 440)) {
                    model.getBoard().putPiece(model.getGame().pieceTwo, model.getXboardMatrix(), model.getYboardMatrix(), 40, 440);
                }
            }

            if(event.getSource() == model.getGame().pieceThree.getCurrentImage()) {
                if (model.getBoard().checkPieceBoundary(model.getGame().pieceThree.getCurrentImage(), 40, 440)) {
                    model.getBoard().putPiece(model.getGame().pieceThree, model.getXboardMatrix(), model.getYboardMatrix(), 40, 440);
                }
            }

            if(event.getSource() == model.getGame().pieceThreeVersion2.getCurrentImage()) {
                if (model.getBoard().checkPieceBoundary(model.getGame().pieceThreeVersion2.getCurrentImage(), 40, 440)) {
                    model.getBoard().putPiece(model.getGame().pieceThreeVersion2, model.getXboardMatrix(), model.getYboardMatrix(), 40, 440);
                }
            }

            if(event.getSource() == model.getGame().pieceFour.getCurrentImage()) {
                if (model.getBoard().checkPieceBoundary(model.getGame().pieceFour.getCurrentImage(), 280, 440)) {
                    model.getBoard().putPiece(model.getGame().pieceFour, model.getXboardMatrix(), model.getYboardMatrix(), 40, 440);
                }
            }

            if(event.getSource() == model.getGame().pieceFive.getCurrentImage()) {
                if (model.getBoard().checkPieceBoundary(model.getGame().pieceFive.getCurrentImage(), 280, 440)) {
                    model.getBoard().putPiece(model.getGame().pieceFive, model.getXboardMatrix(), model.getYboardMatrix(), 280, 440);
                }
            }

            if(event.getSource() == model.getGame().pieceSix.getCurrentImage()) {
                if (model.getBoard().checkPieceBoundary(model.getGame().pieceSix.getCurrentImage(), 570, 440)) {
                    model.getBoard().putPiece(model.getGame().pieceSix, model.getXboardMatrix(), model.getYboardMatrix(), 570, 440);

                }
            }

            if(event.getSource() == model.getGame().pieceSixVersion2.getCurrentImage()) {
                if (model.getBoard().checkPieceBoundary(model.getGame().pieceSixVersion2.getCurrentImage(), 570, 440)) {
                    model.getBoard().putPiece(model.getGame().pieceSixVersion2, model.getXboardMatrix(), model.getYboardMatrix(), 570, 440);

                }
            }

            if(event.getSource() == model.getGame().pieceSeven.getCurrentImage()) {
                if (model.getBoard().checkPieceBoundary(model.getGame().pieceSeven.getCurrentImage(), 570, 440)) {
                    model.getBoard().putPiece(model.getGame().pieceSeven, model.getXboardMatrix(), model.getYboardMatrix(), 570, 440);

                }
            }

            if(event.getSource() == model.getGame().pieceEight.getCurrentImage()) {
                if (model.getBoard().checkPieceBoundary(model.getGame().pieceEight.getCurrentImage(), 570, 440)) {
                    model.getBoard().putPiece(model.getGame().pieceEight, model.getXboardMatrix(), model.getYboardMatrix(), 570, 440);

                }
            }

            if(event.getSource() == model.getGame().pieceNine.getCurrentImage()) {
                if (model.getBoard().checkPieceBoundary(model.getGame().pieceNine.getCurrentImage(), 570, 440)) {
                    model.getBoard().putPiece(model.getGame().pieceNine, model.getXboardMatrix(), model.getYboardMatrix(), 570, 440);

                }
            }

            if(event.getSource() == model.getGame().pieceTen.getCurrentImage()) {
                if (model.getBoard().checkPieceBoundary(model.getGame().pieceTen.getCurrentImage(), 40, 440)) {
                    model.getBoard().putPiece(model.getGame().pieceTen, model.getXboardMatrix(), model.getYboardMatrix(), 40, 440);

                }
            }

            if(event.getSource() == model.getGame().pieceTenVersion2.getCurrentImage()) {
                if (model.getBoard().checkPieceBoundary(model.getGame().pieceTenVersion2.getCurrentImage(), 40, 440)) {
                    model.getBoard().putPiece(model.getGame().pieceTenVersion2, model.getXboardMatrix(), model.getYboardMatrix(), 40, 440);

                }
            }

            if(event.getSource() == model.getGame().pieceEleven.getCurrentImage()) {
                if (model.getBoard().checkPieceBoundary( model.getGame().pieceEleven.getCurrentImage(), 280, 440)) {
                    model.getBoard().putPiece(model.getGame().pieceEleven, model.getXboardMatrix(), model.getYboardMatrix(), 280, 440);

                }
            }

            if(event.getSource() == model.getGame().pieceTwelve.getCurrentImage()) {
                if (model.getBoard().checkPieceBoundary(model.getGame().pieceTwelve.getCurrentImage(), 570, 440)) {
                    model.getBoard().putPiece(model.getGame().pieceTwelve, model.getXboardMatrix(), model.getYboardMatrix(), 570, 440);
                }
            }
            if(event.getSource() == model.getGame().pieceTwo2.getCurrentImage()) {
                if (model.getBoard().checkPieceBoundary(model.getGame().pieceTwo2.getCurrentImage(), 40, 440)) {
                    model.getBoard().putPiece(model.getGame().pieceTwo2, model.getXboardMatrix(), model.getYboardMatrix(), 40, 440);

                }
            }

            if(event.getSource() == model.getGame().pieceEleven2.getCurrentImage()) {
                if (model.getBoard().checkPieceBoundary( model.getGame().pieceEleven2.getCurrentImage(), 280, 440)) {
                    model.getBoard().putPiece(model.getGame().pieceEleven2, model.getXboardMatrix(), model.getYboardMatrix(), 280, 440);

                }
            }

            if(event.getSource() == model.getGame().pieceTwelve2.getCurrentImage()) {
                if (model.getBoard().checkPieceBoundary(model.getGame().pieceTwelve2.getCurrentImage(), 570, 440)) {
                    model.getBoard().putPiece(model.getGame().pieceTwelve2, model.getXboardMatrix(), model.getYboardMatrix(), 570, 440);
                }
            }

        }};



    public Piece getSelectedPiece(){
        return selectedPiece;
    }


}