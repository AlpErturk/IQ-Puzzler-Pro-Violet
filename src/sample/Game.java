package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

    //Levels Declaration Assume we have 5 twoDLevels
    Level levelOne;
    Level levelTwo;
    Level levelThree;
    Level levelFour;
    Level levelFive;

    GameField gameField;

    Piece[] pieces;
    Level[] twoDLevels;

    private int current2DLevel;
    private int current3DLevel;

    private int lastPassed2d;

    private static Game ourInstance = new Game();
    User user;
    DatabaseManager database = new DatabaseManager();

    public static Game getInstance() {
        return ourInstance;
    }

    public static void setInstance(Game gameInstance){
        ourInstance = gameInstance;
    }

    private Game(){
        current2DLevel = 0;
        current3DLevel = 0;
        lastPassed2d = 0;
        user = new User();

        twoDLevels = new Level[15];

        constructPieces();
        constructLevels();
    }

    public void constructPieces(){


            // PIECE 1
            int[][] pieceOneMatrix = new int[4][4];
            pieceOneMatrix[0][1]  = 1;
            pieceOneMatrix[1][1]  = 1;
            pieceOneMatrix[1][0]  = 1;
            pieceOneMatrix[2][0]  = 1;
            pieceOneMatrix[3][0]  = 1;

            int pieceOneId = 1;
            Image pieceOneImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/p1.png");
            ImageView pieceOneImageView = new ImageView(pieceOneImage);

            //---------------------------------------------------------------------------------------------------------

            // PIECE 2
            int[][] pieceTwoMatrix = new int[4][4];
            pieceTwoMatrix[2][0]  = 1;
            pieceTwoMatrix[2][1]  = 1;
            pieceTwoMatrix[2][2]  = 1;
            pieceTwoMatrix[1][2]  = 1;
            pieceTwoMatrix[0][2]  = 1;

            int pieceTwoId = 2;
            Image pieceTwoImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/p2.png");
            ImageView pieceTwoImageView = new ImageView(pieceTwoImage);

            //---------------------------------------------------------------------------------------------------------

            //PIECE 3
            int [][]pieceThreeMatrix = new int[4][4];
            pieceThreeMatrix[0][0] = 1;
            pieceThreeMatrix[0][1] = 1;
            pieceThreeMatrix[0][2] = 1;
            pieceThreeMatrix[0][3] = 1;
            pieceThreeMatrix[1][2] = 1;

            int pieceThreeId = 3;
            Image pieceThreeImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/p3.png");
            ImageView pieceThreeImageView = new ImageView(pieceThreeImage);

            //---------------------------------------------------------------------------------------------------------

            //PIECE 4
            int [][]pieceFourMatrix = new int[4][4];
            pieceFourMatrix[0][0] = 1;
            pieceFourMatrix[1][0] = 1;
            pieceFourMatrix[1][1] = 1;

            int pieceFourId = 4;
            Image pieceFourImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/p4.png");
            ImageView pieceFourImageView = new ImageView(pieceFourImage);


            //---------------------------------------------------------------------------------------------------------

            // PIECE 5
            int[][] pieceFiveMatrix = new int[4][4];
            pieceFiveMatrix[0][1]  = 1;
            pieceFiveMatrix[1][0]  = 1;
            pieceFiveMatrix[1][1]  = 1;
            pieceFiveMatrix[2][1]  = 1;

            int pieceFiveId = 5;
            Image pieceFiveImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/p5.png");
            ImageView pieceFiveImageView = new ImageView(pieceFiveImage);

            //---------------------------------------------------------------------------------------------------------

            // PIECE 6
            int[][] pieceSixMatrix = new int[4][4];
            pieceSixMatrix[0][1]  = 1;
            pieceSixMatrix[1][0]  = 1;
            pieceSixMatrix[1][1]  = 1;
            pieceSixMatrix[2][1]  = 1;
            pieceSixMatrix[2][2]  = 1;

            int pieceSixId = 6;
            Image pieceSixImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/p6.png");
            ImageView pieceSixImageView = new ImageView(pieceSixImage);


            //---------------------------------------------------------------------------------------------------------

            // PIECE 7
            int[][] pieceSevenMatrix = new int[4][4];
            pieceSevenMatrix[0][1]  = 1;
            pieceSevenMatrix[1][0]  = 1;
            pieceSevenMatrix[1][1]  = 1;
            pieceSevenMatrix[2][0]  = 1;

            int pieceSevenId = 7;
            Image pieceSevenImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/p7.png");
            ImageView pieceSevenImageView = new ImageView(pieceSevenImage);

            //---------------------------------------------------------------------------------------------------------

            // PIECE 8
            int[][] pieceEightMatrix = new int[4][4];
            pieceEightMatrix[0][1]  = 1;
            pieceEightMatrix[1][0]  = 1;
            pieceEightMatrix[1][1]  = 1;
            pieceEightMatrix[2][0]  = 1;

            int pieceEightId = 8;
            Image pieceEightImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/p8.png");
            ImageView pieceEightImageView = new ImageView(pieceEightImage);

            //---------------------------------------------------------------------------------------------------------

            // PIECE 9
            int[][] pieceNineMatrix = new int[4][4];
            pieceNineMatrix[0][0]  = 1;
            pieceNineMatrix[0][1]  = 1;
            pieceNineMatrix[1][0]  = 1;
            pieceNineMatrix[1][1]  = 1;
            pieceNineMatrix[1][2]  = 1;

            int pieceNineId = 9;
            Image pieceNineImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/p9.png");
            ImageView pieceNineImageView = new ImageView(pieceNineImage);

            //---------------------------------------------------------------------------------------------------------

            // PIECE 10
            int[][] pieceTenMatrix = new int[4][4];
            pieceTenMatrix[0][0]  = 1;
            pieceTenMatrix[0][1]  = 1;
            pieceTenMatrix[1][1]  = 1;
            pieceTenMatrix[2][1]  = 1;
            pieceTenMatrix[3][1]  = 1;

            int pieceTenId = 10;
            Image pieceTenImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/p10.png");
            ImageView pieceTenImageView = new ImageView(pieceTenImage);

            //---------------------------------------------------------------------------------------------------------

            // PIECE 11
            int[][] pieceElevenMatrix = new int[4][4];
            pieceElevenMatrix[0][0]  = 1;
            pieceElevenMatrix[0][1]  = 1;
            pieceElevenMatrix[0][2]  = 1;
            pieceElevenMatrix[1][0]  = 1;
            pieceElevenMatrix[1][2]  = 1;

            int pieceElevenId = 11;
            Image pieceElevenImage= new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/p11.png");
            ImageView pieceElevenImageView = new ImageView(pieceElevenImage);
            //pieceElevenImageView.setFitWidth(240);
            //pieceElevenImageView.setFitHeight(240);

            //---------------------------------------------------------------------------------------------------------

            // PIECE 12
            int[][] pieceTwelveMatrix = new int[4][4];
            pieceTwelveMatrix[0][0]  = 1;
            pieceTwelveMatrix[1][0]  = 1;
            pieceTwelveMatrix[1][1]  = 1;
            pieceTwelveMatrix[2][1]  = 1;
            pieceTwelveMatrix[2][2]  = 1;

            int pieceTwelveId = 12;
            Image pieceTwelveImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/p12.png");
            ImageView pieceTwelveImageView = new ImageView(pieceTwelveImage);

            //---------------------------------------------------------------------------------------------------------

            //PIECE CONSTRUCTIONS
            pieceOne = new Piece(pieceOneId, pieceOneImageView, pieceOneMatrix);
            pieceTwo = new Piece(pieceTwoId, pieceTwoImageView, pieceTwoMatrix);
            pieceThree = new Piece(pieceThreeId, pieceThreeImageView, pieceThreeMatrix);
            pieceFour = new Piece(pieceFourId, pieceFourImageView, pieceFourMatrix);
            pieceFive = new Piece(pieceFiveId, pieceFiveImageView, pieceFiveMatrix);
            pieceSix = new Piece(pieceSixId, pieceSixImageView, pieceSixMatrix);
            pieceSeven = new Piece(pieceSevenId, pieceSevenImageView, pieceSevenMatrix);
            pieceEight = new Piece(pieceEightId, pieceEightImageView, pieceEightMatrix);
            pieceNine = new Piece(pieceNineId, pieceNineImageView, pieceNineMatrix);
            pieceTen = new Piece(pieceTenId, pieceTenImageView, pieceTenMatrix);
            pieceEleven = new Piece(pieceElevenId, pieceElevenImageView, pieceElevenMatrix);
            pieceTwelve = new Piece(pieceTwelveId, pieceTwelveImageView, pieceTwelveMatrix);

            //---------------------------------------------------------------------------------------------------------

            Piece[] pieces = new Piece[13];

            pieces[0] = pieceOne;
            pieces[1] = pieceTwo;
            pieces[2] = pieceThree;
            pieces[3] = pieceFour;
            pieces[4] = pieceFive;
            pieces[5] = pieceSix;
            pieces[6] = pieceSeven;
            pieces[7] = pieceEight;
            pieces[8] = pieceNine;
            pieces[9] = pieceTen;
            pieces[10] = pieceEleven;
            pieces[11] = pieceTwelve;

    }


    // bu metod bütün levelları initalize eder
    public void constructLevels(){

        int levelWidth = 11;
        int levelHeight = 5;

        //----------------------------------------------------------------------------------------------

        // LEVEL 1 CONSTRUCTION
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


        Image levelOneImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/level1Board.png");
        ImageView levelOneView = new ImageView(levelOneImage);
        levelOne = new Level(0,60, unusedPieces, usedPieces, levelOneMatrix, levelOneView);

        //----------------------------------------------------------------------------------------------

        //LEVEL 2 CONSTRUCTION
        int[][] levelTwoMatrix = new int[levelHeight][levelWidth];
        for(int i = 0; i < levelHeight; i++){
            for(int m = 0; m < levelWidth; m++){
                levelTwoMatrix[i][m] = 1;
            }
        }

        levelTwoMatrix[1][7] = 0;
        levelTwoMatrix[1][9] = 0;
        levelTwoMatrix[2][6] = 0;
        levelTwoMatrix[2][7] = 0;
        levelTwoMatrix[2][8] = 0;
        levelTwoMatrix[2][9] = 0;
        levelTwoMatrix[2][10] = 0;
        levelTwoMatrix[3][7] = 0;
        levelTwoMatrix[3][8] = 0;
        levelTwoMatrix[3][9] = 0;
        levelTwoMatrix[3][10] = 0;
        levelTwoMatrix[4][8] = 0;
        levelTwoMatrix[4][9] = 0;
        levelTwoMatrix[4][10] = 0;

        ArrayList<Piece> usedPieces2 = new ArrayList<>();
        usedPieces2.add(pieceOne);
        usedPieces2.add(pieceTwo);
        usedPieces2.add(pieceThree);
        usedPieces2.add(pieceFour);
        usedPieces2.add(pieceFive);
        usedPieces2.add(pieceSix);
        usedPieces2.add(pieceSeven);
        usedPieces2.add(pieceEight);
        usedPieces2.add(pieceNine);

        ArrayList<Piece> unusedPieces2 = new ArrayList<>();
        unusedPieces2 = new ArrayList<>();
        unusedPieces2.add(pieceTwo);
        unusedPieces2.add(pieceSix);
        unusedPieces2.add(pieceFive);

        Image levelTwoImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/level2Board.png");
        ImageView levelTwoView = new ImageView(levelTwoImage);
        levelTwo = new Level(1,200, unusedPieces2, usedPieces2, levelTwoMatrix, levelTwoView);

        //----------------------------------------------------------------------------------------------

        //LEVEL 3 CONSTRUCTION (Level 6 in real game)

        int[][] levelThreeMatrix = new int[levelHeight][levelWidth];
        for(int i = 0; i < levelHeight; i++){
            for(int m = 0; m < levelWidth; m++){
                levelThreeMatrix[i][m] = 1;
            }
        }

        levelThreeMatrix[2][2] = 0;
        levelThreeMatrix[2][3] = 0;
        levelThreeMatrix[2][4] = 0;
        levelThreeMatrix[2][7] = 0;
        levelThreeMatrix[3][0] = 0;
        levelThreeMatrix[3][1] = 0;
        levelThreeMatrix[3][2] = 0;
        levelThreeMatrix[3][3] = 0;
        levelThreeMatrix[3][4] = 0;
        levelThreeMatrix[4][0] = 0;
        levelThreeMatrix[4][1] = 0;
        levelThreeMatrix[4][2] = 0;
        levelThreeMatrix[4][3] = 0;
        levelThreeMatrix[4][4] = 0;

        ArrayList<Piece> usedPieces3 = new ArrayList<>();
        usedPieces3.add(pieceTwo);
        usedPieces3.add(pieceThree);
        usedPieces3.add(pieceFive);
        usedPieces3.add(pieceSix);
        usedPieces3.add(pieceSeven);
        usedPieces3.add(pieceEight);
        usedPieces3.add(pieceNine);
        usedPieces3.add(pieceEleven);
        usedPieces3.add(pieceTwelve);

        ArrayList<Piece> unusedPieces3 = new ArrayList<>();
        unusedPieces3.add(pieceOne);
        unusedPieces3.add(pieceFour);
        unusedPieces3.add(pieceTen);

        Image levelThreeImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/leve6Board.png");
        ImageView levelThreeView = new ImageView(levelThreeImage);
        levelThree = new Level(2,200, unusedPieces3, usedPieces3, levelThreeMatrix, levelThreeView);

        //----------------------------------------------------------------------------------------------

        //LEVEL 4 CONSTRUCTION (Level 8 in real game)

        int[][] levelFourMatrix = new int[levelHeight][levelWidth];
        for(int i = 0; i < levelHeight; i++){
            for(int m = 0; m < levelWidth; m++){
                levelFourMatrix[i][m] = 1;
            }
        }

        levelFourMatrix[1][1] = 0;
        levelFourMatrix[2][0] = 0;
        levelFourMatrix[2][1] = 0;
        levelFourMatrix[2][2] = 0;
        levelFourMatrix[2][3] = 0;
        levelFourMatrix[3][0] = 0;
        levelFourMatrix[3][1] = 0;
        levelFourMatrix[3][2] = 0;
        levelFourMatrix[3][3] = 0;
        levelFourMatrix[4][0] = 0;
        levelFourMatrix[4][1] = 0;
        levelFourMatrix[4][2] = 0;
        levelFourMatrix[4][3] = 0;

        ArrayList<Piece> usedPieces4 = new ArrayList<>();
        usedPieces4.add(pieceOne);
        usedPieces4.add(pieceTwo);
        usedPieces4.add(pieceFive);
        usedPieces4.add(pieceSix);
        usedPieces4.add(pieceEight);
        usedPieces4.add(pieceNine);
        usedPieces4.add(pieceTen);
        usedPieces4.add(pieceEleven);
        usedPieces4.add(pieceTwelve);

        ArrayList<Piece> unusedPieces4 = new ArrayList<>();
        unusedPieces4.add(pieceThree);
        unusedPieces4.add(pieceFour);
        unusedPieces4.add(pieceSeven);

        Image levelFourImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/level8Board.png");
        ImageView levelFourView = new ImageView(levelFourImage);
        levelFour = new Level(3,200, unusedPieces4, usedPieces4, levelFourMatrix, levelFourView);

        //----------------------------------------------------------------------------------------------

        //LEVEL 5 CONSTRUCTION (Level 10 in real game)

        int[][] levelFiveMatrix = new int[levelHeight][levelWidth];
        for(int i = 0; i < levelHeight; i++){
            for(int m = 0; m < levelWidth; m++){
                levelFiveMatrix[i][m] = 1;
            }
        }

        levelFiveMatrix[0][6] = 0;
        levelFiveMatrix[0][7] = 0;
        levelFiveMatrix[0][8] = 0;
        levelFiveMatrix[0][9] = 0;
        levelFiveMatrix[0][10] = 0;
        levelFiveMatrix[1][6] = 0;
        levelFiveMatrix[1][7] = 0;
        levelFiveMatrix[1][8] = 0;
        levelFiveMatrix[1][9] = 0;
        levelFiveMatrix[1][10] = 0;
        levelFiveMatrix[2][7] = 0;
        levelFiveMatrix[2][8] = 0;
        levelFiveMatrix[2][9] = 0;
        levelFiveMatrix[2][10] = 0;
        levelFiveMatrix[3][8] = 0;
        levelFiveMatrix[3][9] = 0;
        levelFiveMatrix[3][10] = 0;
        levelFiveMatrix[4][8] = 0;
        levelFiveMatrix[4][9] = 0;
        levelFiveMatrix[4][10] = 0;

        ArrayList<Piece> usedPieces5 = new ArrayList<>();
        usedPieces5.add(pieceOne);
        usedPieces5.add(pieceThree);
        usedPieces5.add(pieceFour);
        usedPieces5.add(pieceFive);
        usedPieces5.add(pieceSix);
        usedPieces5.add(pieceSeven);
        usedPieces5.add(pieceEight);
        usedPieces5.add(pieceTen);

        ArrayList<Piece> unusedPieces5 = new ArrayList<>();
        unusedPieces5.add(pieceTwo);
        unusedPieces5.add(pieceNine);
        unusedPieces5.add(pieceEleven);
        unusedPieces5.add(pieceTwelve);

        Image levelFiveImage = new Image("file:/Users/alper/Desktop/Version2IQNude 3/Version2IQNude 3/images/level10Board.png");
        ImageView levelFiveView = new ImageView(levelTwoImage);
        levelFive = new Level(4,200, unusedPieces5, usedPieces5, levelFiveMatrix, levelFiveView);

        //----------------------------------------------------------------------------------------------

        twoDLevels[0] = levelOne;
        twoDLevels[1] = levelTwo;
        twoDLevels[2] = levelThree;
        twoDLevels[3] = levelFour;
        twoDLevels[4] = levelFive;

    }

    public void startNewGame(){
        GameField field = new GameField(twoDLevels[current2DLevel]);

    }

    public void finishGame(int score, int levelId){
        if(lastPassed2d < levelId)
            lastPassed2d = levelId;

        twoDLevels[levelId++].setUnlocked(false);
        setLevelScore(levelId, score);
    }

    public void setSettings(){
        // Will be imlemented later
    }

    public void setLevelScore(int levelid, int score){
        twoDLevels[levelid].setHighScore(score);
    }

    public void nextLevel(){
        current2DLevel++;
    }



    public void loadLevel(int levelId){
        //GameField(twoDLevels[levelId);

    }

    public void printUserInfo(){
        System.out.println("USER:");
        System.out.println("username: " + user.getUsername() + "\nscore: " + user.getScore() + "\nlast passed: " + user.getLastPassedLevel());
    }

    public void setUser(User newUser){
        user = newUser;
    }

    //database update method
    public void updateDB(){
        //update database by user values

        String username = user.getUsername();
        int score = database.retrieveScore(username) + 40;
        int lastLevelPassed = user.getLastPassedLevel();

        database.updateLevelPassed(username,lastLevelPassed);
        database.updateScore(username, score);
    }

    //TEST İÇİN YAZILDI
    public void GameOver(){
        updateDB();
    }

    public int getCurrent2DLevel(){
        return current2DLevel;
    }
}
