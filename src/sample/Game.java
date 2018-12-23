package sample;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Game {
    Piece pieceOne;
    Piece pieceTwo;
    Piece pieceThree;
    Piece pieceFour;
    Piece pieceFive;
    Piece pieceSix;
    Piece pieceSeven;
    Piece pieceEight;
    Piece pieceNine;
    Piece pieceTen;
    Piece pieceEleven;
    Piece pieceTwelve;

    Level levelOne;

    GameField gameField;


    Piece[] pieces;
    Level[] levels;

    private int current2DLevel;
    private int current3DLevel;

    private int lastPassed2d;





    private static Game ourInstance = new Game();

    public static Game getInstance() {
        return ourInstance;
    }

    private Game(){
        constructPieces();
        constructLevels();

        lastPassed2d = 0;
        current2DLevel = 0;
        current3DLevel = 0;

    }



    public void constructPieces(){

        int[][] pieceTenMatrix = new int[4][4];
        pieceTenMatrix[0][0]  = 1;
        pieceTenMatrix[1][0]  = 1;
        pieceTenMatrix[1][1]  = 1;
        pieceTenMatrix[1][2]  = 1;
        pieceTenMatrix[1][3]  = 1;

        int pieceTenId = 10;
        Image pieceTenImage = new Image("file:/Users/safaaskin/IdeaProjects/Deneme/images/piece10.png");


       int[][] pieceElevenMatrix = new int[4][4];
       pieceElevenMatrix[0][0]  = 1;
       pieceElevenMatrix[1][0]  = 1;
       pieceElevenMatrix[2][0]  = 1;
       pieceElevenMatrix[0][1]  = 1;
       pieceElevenMatrix[2][1]  = 1;
       int pieceElevenId = 11;
       Image pieceElevenImage= new Image("file:/Users/safaaskin/IdeaProjects/Deneme/images/piece11.png");

        int[][] pieceTwelveMatrix = new int[4][4];
        pieceTwelveMatrix[0][0]  = 1;
        pieceTwelveMatrix[0][1]  = 1;
        pieceTwelveMatrix[1][1]  = 1;
        pieceTwelveMatrix[1][2]  = 1;
        pieceTwelveMatrix[2][2]  = 1;

        int pieceTwelveId = 12;
        Image pieceTwelveImage = new Image("file:/Users/safaaskin/IdeaProjects/Deneme/images/piece12.png");


        pieceTen = new Piece(pieceTenId, pieceTenImage, pieceTenMatrix);
        pieceEleven = new Piece(pieceElevenId, pieceElevenImage, pieceElevenMatrix);
        pieceTwelve = new Piece(pieceTwelveId, pieceTwelveImage, pieceTwelveMatrix);

        Piece[] pieces = new Piece[13];

    }

    // bu metod bütün levelları initalize eder
    public void constructLevels(){

        int levelWidth = 11;
        int levelHeight = 5;

        int[][] levelOneMatrix = new int[levelHeight][levelWidth];
        for(int i = 0; i < levelHeight; i++){
            for(int m = 0; m < levelWidth; m++){
                levelOneMatrix[i][m] = 1;
            }
        }

        levelOneMatrix[0][10] = 0;
        levelOneMatrix[1][10] = 0;
        levelOneMatrix[2][10] = 0;
        levelOneMatrix[3][10] = 0;
        levelOneMatrix[4][10] = 0;
        levelOneMatrix[0][9] = 0;
        levelOneMatrix[1][9] = 0;
        levelOneMatrix[2][9] = 0;
        levelOneMatrix[3][9] = 0;
        levelOneMatrix[4][9] = 0;
        levelOneMatrix[4][9] = 0;
        levelOneMatrix[1][8] = 0;
        levelOneMatrix[2][8] = 0;
        levelOneMatrix[3][8] = 0;
        levelOneMatrix[1][7] = 0;
        levelOneMatrix[2][7] = 0;

        ArrayList<Piece> usedPieces = new ArrayList<>();
        usedPieces.add(pieceOne);
        usedPieces.add(pieceTwo);
        usedPieces.add(pieceThree);
        usedPieces.add(pieceFour);
        usedPieces.add(pieceFive);
        usedPieces.add(pieceSix);
        usedPieces.add(pieceSeven);
        usedPieces.add(pieceEight);
        usedPieces.add(pieceNine);


        ArrayList<Piece> unusedPieces = new ArrayList<>();
        unusedPieces.add(pieceTen);
        unusedPieces.add(pieceEleven);
        unusedPieces.add(pieceTwelve);


        levelOne = new Level(0,200, unusedPieces, usedPieces, levelOneMatrix);


        Level[] level = new Level[15];
        level[0] = levelOne;

        /*
        level[2] = levelTwo;
        level[3] = levelOne;
        level[4] = levelTwo;
        level[5] = levelOne;
        level[6] = levelTwo;
        level[7] = levelOne;
        level[8] = levelTwo;
        level[9] = levelOne;
        level[10] = levelTwo;
        */

    }


    public void startNewGame(){
        GameField field = new GameField(levels[current2DLevel]);

    }


    //hangi levela
    //bu method hangi levelin başlatılması gerektiğini alır ve ona göre oyunu kurgular

    /*public void loadGame(int levelId){
        if(lastPassed2d > levelId)
            GameField field = new GameField(levels[levelId]);

        else{
            //Bu levela daha erişilemedi dialog box çıkıcak
        }
    }
    */

    public void finishGame(int score, int levelId){
        if(lastPassed2d < levelId)
            lastPassed2d = levelId;

        levels[levelId++].setUnlocked(false);
        setLevelScore(levelId, score);
    }

    public void setSettings(){
        // Will be imlemented later
    }

    public void setLevelScore(int levelid, int score){
        levels[levelid].setHighScore(score);
    }

    public void nextLevel(){
        current2DLevel++;
        GameField field = new GameField(levels[current2DLevel]);
    }

    public void loadLevel(int levelId){
        //GameField(levels[levelId);

    }
}
