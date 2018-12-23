package sample;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Level {
    private int highScore;
    private int time;
    private int levelNo;
    private boolean isUnlocked;
    private int[][] levelMatrix;


    ArrayList<Piece> unusedPieces;
    ArrayList<Piece> usedPieces;


    public Level(int levelNo, int time, ArrayList<Piece>unusedPieces, ArrayList<Piece> usedPieces, int[][]levelMatrix){
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


    /*public void addPiecesLevel(ArrayList<Piece> usedPieces){
    bu Method manuel olarak array doldurmadan pieceleri levele hızlıca eklemeyi sağlıyo
    }

    */

}
