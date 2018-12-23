package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GameField{
    Game game;
    Board board2d;
    Level level;

    ArrayList<Piece> usedPieces;
    ArrayList<Piece> unusedPieces;

    private int elapsedTime;


    public GameField(Level level){

        game = Game.getInstance();

        //board2d = new Board(level.getLevelMatrix());
    }

    public int calculateScore(){
        int score = 10;
        //write the score calculation method here

        return score;

    }


    public long elapsedTime(){
        return System.currentTimeMillis();
    }

    public void movementCount(){
        //will be implemented later
    }

    public void updateUsedPieces(Piece piece){
        usedPieces.remove(piece);
        unusedPieces.add(piece);
    }

    public void updateUnusedPieces(Piece piece) {
        unusedPieces.remove(piece);
        usedPieces.add(piece);
    }

    public boolean isGameComplete(){
        return board2d.isFull();
    }



    public void gameOver(){
        System.out.print("gameOver");

    }

    public boolean isGameFinished(){

        if(board2d.isFull()){
            int score = calculateScore();
            game.setLevelScore(level.getLevelNo(), score);
            return true;
        }
        else
            return false;
    }


}
