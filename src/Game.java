package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Game {

    Piece pieceOne;
    Piece pieceTwo;
    Piece pieceThree;
    Piece pieceThreeVersion2;
    Piece pieceFour;
    Piece pieceFive;
    Piece pieceSix;
    Piece pieceSixVersion2;
    Piece pieceSeven;
    Piece pieceEight;
    Piece pieceNine;
    Piece pieceTen;
    Piece pieceTenVersion2;
    Piece pieceEleven;
    Piece pieceTwelve;
    Piece pieceTwelve2;
    Piece pieceTwo2;
    Piece pieceEleven2;

    //Levels Declaration Assume we have 5 twoDLevels
    Level levelOne;
    Level levelTwo;
    Level levelThree;
    Level levelFour;
    Level levelFive;
    Level levelSix;
    Level levelSeven;

    Level[] twoDLevels;

    private int current2DLevel;
    private int current3DLevel;

    private int lastPassed2d;

    private static Game ourInstance = new Game();

    User user;
    DatabaseManager database;

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
        database = new DatabaseManager();

        twoDLevels = new Level[15];

        constructPieces();
        constructLevels();
    }

    public void constructPieces(){


            // PIECE 1
            int[][] pieceOneMatrix = new int[4][4];
            pieceOneMatrix[0][0]  = 1;
            pieceOneMatrix[1][0]  = 1;
            pieceOneMatrix[2][0]  = 1;
            pieceOneMatrix[2][1]  = 1;
            pieceOneMatrix[3][1]  = 1;

            int pieceOneId = 1;
            Image pieceOneImage = new Image("file:images/p1.png");
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
            Image pieceTwoImage = new Image("file:images/p2.png");
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
            Image pieceThreeImage = new Image("file:images/p3.png");
            ImageView pieceThreeImageView = new ImageView(pieceThreeImage);

            //---------------------------------------------------------------------------------------------------------


            //PIECE 3 Version 2
            int [][]pieceThreeVersion2Matrix = new int[4][4];
            pieceThreeVersion2Matrix[0][0] = 1;
            pieceThreeVersion2Matrix[0][1] = 1;
            pieceThreeVersion2Matrix[0][2] = 1;
            pieceThreeVersion2Matrix[0][3] = 1;
            pieceThreeVersion2Matrix[1][2] = 1;

            int pieceThreeVersion2Id = 30;
            Image pieceThreeVersion2Image = new Image("file:images/p3Version2.png");
            ImageView pieceThreeVersion2ImageView = new ImageView(pieceThreeVersion2Image);

            //---------------------------------------------------------------------------------------------------------

            //PIECE 4
            int [][]pieceFourMatrix = new int[4][4];
            pieceFourMatrix[0][0] = 1;
            pieceFourMatrix[1][0] = 1;
            pieceFourMatrix[1][1] = 1;

            int pieceFourId = 4;
            Image pieceFourImage = new Image("file:images/p4.png");
            ImageView pieceFourImageView = new ImageView(pieceFourImage);


            //---------------------------------------------------------------------------------------------------------

            // PIECE 5
            int[][] pieceFiveMatrix = new int[4][4];
            pieceFiveMatrix[0][1]  = 1;
            pieceFiveMatrix[1][0]  = 1;
            pieceFiveMatrix[1][1]  = 1;
            pieceFiveMatrix[2][1]  = 1;

            int pieceFiveId = 5;
            Image pieceFiveImage = new Image("file:images/p5.png");
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
            Image pieceSixImage = new Image("file:images/p6.png");
            ImageView pieceSixImageView = new ImageView(pieceSixImage);

        //---------------------------------------------------------------------------------------------------------

            // PIECE 6 VERSION 2
            int[][] pieceSixVersion2Matrix = new int[4][4];
            pieceSixVersion2Matrix[0][2]  = 1;
            pieceSixVersion2Matrix[1][2]  = 1;
            pieceSixVersion2Matrix[1][3]  = 1;
            pieceSixVersion2Matrix[2][1]  = 1;
            pieceSixVersion2Matrix[2][2]  = 1;

            int pieceSixVersion2Id = 60;
            Image pieceSixVersion2Image = new Image("file:images/p6Version2.png");
            ImageView pieceSixVersion2ImageView = new ImageView(pieceSixVersion2Image);

        //---------------------------------------------------------------------------------------------------------

            // PIECE 7
            int[][] pieceSevenMatrix = new int[4][4];
            pieceSevenMatrix[0][1]  = 1;
            pieceSevenMatrix[1][0]  = 1;
            pieceSevenMatrix[1][1]  = 1;
            pieceSevenMatrix[2][0]  = 1;

            int pieceSevenId = 7;
            Image pieceSevenImage = new Image("file:images/p7.png");
            ImageView pieceSevenImageView = new ImageView(pieceSevenImage);

            //---------------------------------------------------------------------------------------------------------

            // PIECE 8
            int[][] pieceEightMatrix = new int[4][4];
            pieceEightMatrix[0][1]  = 1;
            pieceEightMatrix[1][0]  = 1;
            pieceEightMatrix[1][1]  = 1;
            pieceEightMatrix[2][0]  = 1;

            int pieceEightId = 8;
            Image pieceEightImage = new Image("file:images/p8.png");
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
            Image pieceNineImage = new Image("file:images/p9.png");
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
            Image pieceTenImage = new Image("file:images/p10.png");
            ImageView pieceTenImageView = new ImageView(pieceTenImage);

            //---------------------------------------------------------------------------------------------------------


            // PIECE 10 Version 2
            int[][] pieceTenVersion2Matrix = new int[4][4];
            pieceTenVersion2Matrix[0][2]  = 1;
            pieceTenVersion2Matrix[0][3]  = 1;
            pieceTenVersion2Matrix[1][2]  = 1;
            pieceTenVersion2Matrix[2][2]  = 1;
            pieceTenVersion2Matrix[3][2]  = 1;

            int pieceTenVersion2Id = 100;
            Image pieceTenVersion2Image = new Image("file:images/p10Version2.png");
            ImageView pieceTenVersion2ImageView = new ImageView(pieceTenVersion2Image);


        //---------------------------------------------------------------------------------------------------------

            // PIECE 11
            int[][] pieceElevenMatrix = new int[4][4];
            pieceElevenMatrix[0][0]  = 1;
            pieceElevenMatrix[0][1]  = 1;
            pieceElevenMatrix[0][2]  = 1;
            pieceElevenMatrix[1][0]  = 1;
            pieceElevenMatrix[1][2]  = 1;

            int pieceElevenId = 11;
            Image pieceElevenImage= new Image("file:images/p11.png");
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
            Image pieceTwelveImage = new Image("file:images/p12.png");
            ImageView pieceTwelveImageView = new ImageView(pieceTwelveImage);

        //---------------------------------------------------------------------------------------------------------
        // PIECE 13
        int[][] pieceTwo2Matrix = new int[4][4];
        pieceTwo2Matrix[2][0]  = 1;
        pieceTwo2Matrix[2][1]  = 1;
        pieceTwo2Matrix[2][2]  = 1;
        pieceTwo2Matrix[1][2]  = 1;
        pieceTwo2Matrix[0][2]  = 1;

        int pieceTwo2Id = 2;
        Image pieceTwo2Image = new Image("file:images/p2.png");
        ImageView pieceTwo2ImageView = new ImageView(pieceTwo2Image);

        //---------------------------------------------------------------------------------------------------------

        // PIECE 12-2
        int[][] pieceTwelve2Matrix = new int[4][4];
        pieceTwelve2Matrix[0][0]  = 1;
        pieceTwelve2Matrix[1][0]  = 1;
        pieceTwelve2Matrix[1][1]  = 1;
        pieceTwelve2Matrix[2][1]  = 1;
        pieceTwelve2Matrix[2][2]  = 1;

        int pieceTwelve2Id = 12;
        Image pieceTwelve2Image = new Image("file:images/p12.png");
        ImageView pieceTwelve2ImageView = new ImageView(pieceTwelve2Image);
        //---------------------------------------------------------------------------------------------------------

        // PIECE 11-2
        int[][] pieceEleven2Matrix = new int[4][4];
        pieceEleven2Matrix[0][0]  = 1;
        pieceEleven2Matrix[0][1]  = 1;
        pieceEleven2Matrix[0][2]  = 1;
        pieceEleven2Matrix[1][0]  = 1;
        pieceEleven2Matrix[1][2]  = 1;

        int pieceEleven2Id = 11;
        Image pieceEleven2Image= new Image("file:images/p11.png");
        ImageView pieceEleven2ImageView = new ImageView(pieceEleven2Image);


        //PIECE CONSTRUCTIONS
            pieceOne = new Piece(pieceOneId, pieceOneImageView, pieceOneMatrix);
            pieceTwo = new Piece(pieceTwoId, pieceTwoImageView, pieceTwoMatrix);
            pieceThree = new Piece(pieceThreeId, pieceThreeImageView, pieceThreeMatrix);
            pieceThreeVersion2 = new Piece(pieceThreeVersion2Id, pieceThreeVersion2ImageView, pieceThreeVersion2Matrix);
            pieceFour = new Piece(pieceFourId, pieceFourImageView, pieceFourMatrix);
            pieceFive = new Piece(pieceFiveId, pieceFiveImageView, pieceFiveMatrix);
            pieceSix = new Piece(pieceSixId, pieceSixImageView, pieceSixMatrix);
            pieceSixVersion2 = new Piece(pieceSixVersion2Id, pieceSixVersion2ImageView, pieceSixVersion2Matrix);
            pieceSeven = new Piece(pieceSevenId, pieceSevenImageView, pieceSevenMatrix);
            pieceEight = new Piece(pieceEightId, pieceEightImageView, pieceEightMatrix);
            pieceNine = new Piece(pieceNineId, pieceNineImageView, pieceNineMatrix);
            pieceTen = new Piece(pieceTenId, pieceTenImageView, pieceTenMatrix);
            pieceTenVersion2 = new Piece(pieceTenVersion2Id, pieceTenVersion2ImageView, pieceTenVersion2Matrix);
            pieceEleven = new Piece(pieceElevenId, pieceElevenImageView, pieceElevenMatrix);
            pieceTwelve = new Piece(pieceTwelveId, pieceTwelveImageView, pieceTwelveMatrix);
            pieceTwo2 = new Piece(pieceTwo2Id, pieceTwo2ImageView, pieceTwo2Matrix);
            pieceTwelve2 = new Piece(pieceTwelveId, pieceTwelve2ImageView, pieceTwelve2Matrix);
            pieceEleven2 = new Piece(pieceEleven2Id, pieceEleven2ImageView, pieceEleven2Matrix);


            //---------------------------------------------------------------------------------------------------------
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

        ArrayList<Piece> unusedPieces = new ArrayList<>();
        unusedPieces.add(pieceTen);
        unusedPieces.add(pieceEleven);
        unusedPieces.add(pieceTwelve);


        Image levelOneImage = new Image("file:images/level1Board.png");
        ImageView levelOneView = new ImageView(levelOneImage);
        levelOne = new Level(0,60, unusedPieces, levelOneMatrix, levelOneView);

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


        ArrayList<Piece> unusedPieces2 = new ArrayList<>();
        unusedPieces2 = new ArrayList<>();
        unusedPieces2.add(pieceTwo);
        unusedPieces2.add(pieceSix);
        unusedPieces2.add(pieceFive);

        Image levelTwoImage = new Image("file:images/level2Board.png");
        ImageView levelTwoView = new ImageView(levelTwoImage);
        levelTwo = new Level(1,60, unusedPieces2, levelTwoMatrix, levelTwoView);

        //----------------------------------------------------------------------------------------------

        //LEVEL 3 CONSTRUCTION (Level 6 in real game)

        int[][] levelThreeMatrix = new int[levelHeight][levelWidth];
        for(int i = 0; i < levelHeight; i++){
            for(int m = 0; m < levelWidth; m++){
                levelThreeMatrix[i][m] = 2;
            }
        }

        levelThreeMatrix[2][2] = 0;
        levelThreeMatrix[2][3] = 0;
        levelThreeMatrix[2][4] = 0;
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

        ArrayList<Piece> unusedPieces3 = new ArrayList<>();
        unusedPieces3.add(pieceOne);
        unusedPieces3.add(pieceFour);
        unusedPieces3.add(pieceTenVersion2);

        Image levelThreeImage = new Image("file:images/level6Board.png");
        ImageView levelThreeView = new ImageView(levelThreeImage);
        levelThree = new Level(2,60, unusedPieces3,  levelThreeMatrix, levelThreeView);

        //----------------------------------------------------------------------------------------------

        //LEVEL 4 CONSTRUCTION (Level 8 in real game)

        int[][] levelFourMatrix = new int[levelHeight][levelWidth];
        for(int i = 0; i < levelHeight; i++){
            for(int m = 0; m < levelWidth; m++){
                levelFourMatrix[i][m] = 0;
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

        ArrayList<Piece> unusedPieces4 = new ArrayList<>();
        unusedPieces4.add(pieceThreeVersion2);
        unusedPieces4.add(pieceFour);
        unusedPieces4.add(pieceSix);

        Image levelFourImage = new Image("file:images/level8Board.png");
        ImageView levelFourView = new ImageView(levelFourImage);
        levelFour = new Level(3,60, unusedPieces4, levelFourMatrix, levelFourView);

        //----------------------------------------------------------------------------------------------

        //LEVEL 5 CONSTRUCTION (Level 10 in real game)

        int[][] levelFiveMatrix = new int[levelHeight][levelWidth];
        for(int i = 0; i < levelHeight; i++){
            for(int m = 0; m < levelWidth; m++){
                levelFiveMatrix[i][m] = 13;
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


        ArrayList<Piece> unusedPieces5 = new ArrayList<>();
        unusedPieces5.add(pieceTwo2);
        unusedPieces5.add(pieceNine);
        unusedPieces5.add(pieceEleven2);
        unusedPieces5.add(pieceTwelve2);

        Image levelFiveImage = new Image("file:images/level10Board.png");
        ImageView levelFiveView = new ImageView(levelFiveImage);
        levelFive = new Level(4,120, unusedPieces5, levelFiveMatrix, levelFiveView);

        //----------------------------------------------------------------------------------------------

        //LEVEL 6 CONSTRUCTION (12 in real game)

        int[][] levelSixMatrix = new int[levelHeight][levelWidth];
        for(int i = 0; i < levelHeight; i++){
            for(int m = 0; m < levelWidth; m++){
                levelSixMatrix[i][m] = 2;
            }
        }

        levelSixMatrix[1][0] = 0;
        levelSixMatrix[2][0] = 0;
        levelSixMatrix[3][0] = 0;
        levelSixMatrix[4][0] = 0;
        levelSixMatrix[2][1] = 0;
        levelSixMatrix[3][1] = 0;
        levelSixMatrix[4][1] = 0;
        levelSixMatrix[2][2] = 0;
        levelSixMatrix[3][2] = 0;
        levelSixMatrix[4][2] = 0;
        levelSixMatrix[1][3] = 0;
        levelSixMatrix[2][3] = 0;
        levelSixMatrix[3][3] = 0;
        levelSixMatrix[4][3] = 0;
        levelSixMatrix[1][4] = 0;
        levelSixMatrix[2][4] = 0;
        levelSixMatrix[3][4] = 0;
        levelSixMatrix[4][4] = 0;
        levelSixMatrix[4][5] = 0;
        levelSixMatrix[3][5] = 0;

        ArrayList<Piece> unusedPieces6 = new ArrayList<>();
        unusedPieces6.add(pieceThreeVersion2);
        unusedPieces6.add(pieceTenVersion2);
        unusedPieces6.add(pieceTwelve);
        unusedPieces6.add(pieceSixVersion2);

        Image levelSixImage = new Image("file:images/level12Board.png");
        ImageView levelSixView = new ImageView(levelSixImage);
        levelSix = new Level(5,60, unusedPieces6, levelSixMatrix, levelSixView);

        //----------------------------------------------------------------------------------------------

        //LEVEL 7 CONSTRUCTION (35 in real game)

        int[][] levelSevenMatrix = new int[levelHeight][levelWidth];
        for(int i = 0; i < levelHeight; i++){
            for(int m = 0; m < levelWidth; m++){
                levelSevenMatrix[i][m] = 0;
            }
        }
        levelSevenMatrix[0][0] = 2;
        levelSevenMatrix[1][0] = 2;
        levelSevenMatrix[2][0] = 2;
        levelSevenMatrix[0][1] = 2;
        levelSevenMatrix[1][1] = 2;
        levelSevenMatrix[0][2] = 2;
        levelSevenMatrix[1][2] = 2;
        levelSevenMatrix[0][3] = 2;
        levelSevenMatrix[0][4] = 2;
        levelSevenMatrix[1][4] = 2;
        levelSevenMatrix[2][4] = 2;
        levelSevenMatrix[2][5] = 2;
        levelSevenMatrix[2][6] = 2;
        levelSevenMatrix[3][6] = 2;


        ArrayList<Piece> unusedPieces7 = new ArrayList<>();
        unusedPieces7.add(pieceOne);
        unusedPieces7.add(pieceTwo);
        unusedPieces7.add(pieceThree);
        unusedPieces7.add(pieceFour);
        unusedPieces7.add(pieceFive);
        unusedPieces7.add(pieceSix);
        unusedPieces7.add(pieceSeven);
        unusedPieces7.add(pieceTen);
        unusedPieces7.add(pieceTwelve);

        Image levelSevenImage = new Image("file:images/level35.png");
        ImageView levelSevenView = new ImageView(levelSevenImage);
        levelSeven = new Level(6,60, unusedPieces7, levelSevenMatrix, levelSevenView);

        //----------------------------------------------------------------------------------------------
        
        twoDLevels[0] = levelOne;
        twoDLevels[1] = levelTwo;
        twoDLevels[2] = levelThree;
        twoDLevels[3] = levelFive;
        twoDLevels[4] = levelSix;
        twoDLevels[5] = levelTwo;
        twoDLevels[6] = levelOne;

        //twoDLevels[5] = levelSeven;
        //twoDLevels[6] = levelFour;
    }


    public void finishGame(int score, int levelId){
        if(lastPassed2d < levelId)
            lastPassed2d = levelId;
        twoDLevels[current2DLevel].setHighScore(score);
        current2DLevel++;
        userScore();
        System.out.print("this last pass" + lastPassed2d);
    }

    public void setSettings(){
        // Will be imlemented later
    }

    public void nextLevel(){

        user.setLastPassedLevel(current2DLevel + 1);

        //SİL
        printUserInfo();

        current2DLevel++;
    }



    public void setUser(User newUser){
        user = newUser;
    }

    public void printUserInfo(){
        System.out.println("USER:");
        System.out.println("username: " + user.getUsername() + "\nscore: " + user.getScore() + "\nlast passed: " + user.getLastPassedLevel());
    }

    public int getCurrent2DLevel(){
        return current2DLevel;
    }


    public void replayLevel(){
        current2DLevel+=1;
        current2DLevel-=1;
    }

    public void replay(){
        try {
            twoDLevels[current2DLevel].setElapsedTime(0);
            Parent root = FXMLLoader.load(getClass().getResource("View/GameOverScreen.fxml"));
            Stage window = Main.getMainStage();
            Scene scene = new Scene(root);
            window.setTitle("GAME OVER");
            window.setScene(scene);
            window.centerOnScreen();
            Main.setMainStage(window);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void userScore(){

        int totalScore = 0;
        for(int i = 0; i < lastPassed2d + 1; i++)
            totalScore += twoDLevels[i].getHighScore();
        System.out.println("totalScore"+ totalScore);

        user.setScore(totalScore);
        user.setLastPassedLevel(lastPassed2d);
        database.updateScore(user.getUsername(), user.getScore());
        database.updateLevelPassed(user.getUsername(), user.getLastPassedLevel());
    }

    public int getLastPassed2d(){
        return lastPassed2d;
    }

    public void setCurrent2DLevel(int level){
        current2DLevel = level;
    }



}

