package sample;

import javafx.scene.image.ImageView;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Level {
    private int highScore;
    private int time;
    private int levelNo;
    private boolean isUnlocked;
    private int[][] levelMatrix;
    private int[][] finishedLevelMatrix;
    private ImageView boardView;


    ArrayList<Piece> unusedPieces;
    ArrayList<Piece> usedPieces;


    public Level(int levelNo, int time, ArrayList<Piece>unusedPieces, ArrayList<Piece> usedPieces, int[][]levelMatrix, ImageView board){
        boardView = board;
        this.levelMatrix = levelMatrix;
        this.levelNo = levelNo;
        this.time = time;
        highScore = 0;
        this.unusedPieces = unusedPieces;
        this.usedPieces = usedPieces;
        isUnlocked = false;
    }

    public void setHighScore(int highScore){
        if(this.highScore < highScore)
            this.highScore = highScore;
    }

    public ImageView getBoardView(){
        return boardView;
    }
    public int getTime(){
        return time;
    }

    public int[][] getLevelMatrix(){
        return levelMatrix;
    }

    public int getLevelNo(){
        return levelNo;
    }

    public void setUnlocked(boolean lock){
        isUnlocked = lock;
    }

    public boolean getUnlocked(){
        return isUnlocked;
    }

    public void constructGameField(){

    }

    //bu metod levellarda kullanılacak piecelerin initial positionlarını ayarlar
    public ArrayList<Piece> constructPiecePositions(){
        ArrayList<Piece> list = new ArrayList<>();
        return list;
    }

    public ArrayList<Piece> getUnusedPieces(){
        return unusedPieces;
    }

    public ArrayList<Piece> getUsedPieces(){ return usedPieces; }
}
