/*
* Author: Elif Gulsah Kasdogan
* Class: Database Manager
* Handles database connection and related operations: sign in/sign up
 */
package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PipedReader;
import java.sql.*;

public class DatabaseManager {
    // all operations related to database will be done in this class
    private final String TABLE_NAME = "table2";
    private final int MAX_SIZE = 100;
    private ConnectionManager connectionManager;
    private Connection connection; //database connection
    private Game game;
    private User user; //bu user boş.

    public DatabaseManager(){
        game = Game.getInstance();
        user = new User();
        connectionManager = new ConnectionManager();
        connection = null;
    }

    //return true if log in is successful
    public boolean logIn(String name, String passw) throws IOException {
        boolean result = false;
        openDatabaseConnection();
        if (userExists(name)) {
            //if user exist you can log in
            ResultSet rs = null;
            try {
                String query = "SELECT * FROM " + TABLE_NAME +" WHERE USERNAME = ? AND PASSWORD = ?";
                PreparedStatement pst = connection.prepareStatement(query);
                pst.setString(1, name);
                pst.setString(2, passw);
                rs = pst.executeQuery();
                int count = 0;
                while(rs.next()){
                    count++;
                }
                //count = 1 --> one user exists with the given username and password
                //count > 1 --> multpile users exists with the same username and password (precondition check is done)
                //count = 0 --> user DNE
                if(count == 1){
                    //log in successful
                    System.out.println("Successful log in");
                    //game.setUsername(name); //NULL POINTER yedik
                    //read level and score from database

                    int level = -9; //databaseden çekilecek
                    level = retrieveLevel(name);

                    int score = -9; //databaseden çekilecek
                    score = retrieveScore(name);

                    user.setUsername(name);
                    user.setScore(score);
                    user.setLastPassedLevel(level);
                    game.setUser(user); //game now has the user
                    game.printUserInfo();
                    result = true;
                }
                else{
                    System.out.println("Unsuccessful log in");
                }
            }
            catch(SQLException e){
                System.out.println("Exception in logIn method" + e);
            }
        }
        closeDatabaseConnection();
        return result;
    }

    //return true if register is successful
    public boolean registerUser(String username, String password){
        //add new user to database if username is not taken
        //first open database connection
        openDatabaseConnection();
        if(!userExists(username)){
            System.out.println("User does not exists");
            //user is not in database
            int levelNo = 0; //initial level is 0
            int score = 0; //initially score is 0
            String sql = "INSERT INTO " + TABLE_NAME + " (username,password,level,totalScore) VALUES(?,?,?,?)";

            try {
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1,username);
                pstmt.setString(2,password);
                pstmt.setInt(3,levelNo);
                pstmt.setInt(4, score);
                pstmt.executeUpdate();

                //user ın score ve level ı ayarlanmalı
                user.setUsername(username);
                user.setScore(score);
                user.setLastPassedLevel(levelNo);

                game.setUser(user); //game now has the user
                game.printUserInfo();

                return true;

            } catch(SQLException e){
                System.out.println("Exception in register user method" + e);
                return false;
            }
        }
        else{
            System.out.println("User exists!");
        }
        return false;
    }

    //returns true if user exists
    public boolean userExists(String name){
        //check database
        //return true if user is in database
        boolean result = false;
        ResultSet rs = null;
        try{
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE USERNAME = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1,name);
            rs = pst.executeQuery();

            int count = 0;
            while(rs.next()){
                count++;
            }
            if(count == 1){
                //user exists
                result  = true;
            }
            //if(count > 1) --> user duplicate but we will not have such a case
            else{
                //user does not exist
                result = false;
            }

        } catch(SQLException e){
            System.out.println("Exception in userExists method: " + e);
        }
        return result;
    }

    //return true if update score is successful
    //update score in database
    public boolean updateScore(String username, int score){
        //return true if score change is successful
        /*
        updateScore ve updateLevelPasssed oyun bittikten sonra çağırılacak
        oyunu oynayan kişinin bilgileri database e yazılabilsin diye
         */
        boolean result = false;
        openDatabaseConnection();

        if(userExists(username)){
            //update score if user exists

            String sql = "UPDATE " + TABLE_NAME + " SET TOTALSCORE = ? WHERE USERNAME = ?";
            try {
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setInt(1, score);
                pst.setString(2,username);
                pst.executeUpdate();
                result = true;

            } catch (SQLException e) {
                System.out.println("Exception in updateScore method" + e);
                //e.printStackTrace();
            }
        }

        closeDatabaseConnection();
        return result;
    }

    //update last level passed in database, return true if update is successful
    public boolean updateLevelPassed(String username, int levelPassed){

        //oyundan userın son levelını alıp database e yazacak
        openDatabaseConnection();
        int level = 0;

        if(userExists(username)){
            String sql = "UPDATE " + TABLE_NAME + " SET LEVEL = ? WHERE USERNAME = ?";

            level = levelPassed; //write last passed level of user object to database

            try {
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setInt(1, level);
                pst.setString(2, username);
                pst.executeUpdate();
                closeDatabaseConnection();
                return true;

            } catch (SQLException e) {
                System.out.println("Exception in updateLevel method" + e);
            }
        }
        closeDatabaseConnection();
        return false;
    }

    public void openDatabaseConnection(){
        connection = connectionManager.getConnection(); // we will use this connection to change database
    }

    public void closeDatabaseConnection(){
        try{
            connection.close();

        } catch(SQLException e){
            System.out.println("Cannot close Database");
        }

    }

    //returns last passed level of user
    public int retrieveLevel(String username){
        openDatabaseConnection();
        int level = 0;
        String sql = "SELECT LEVEL FROM " + TABLE_NAME + " WHERE USERNAME = ?";
        ResultSet rs = null;
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,username);
            rs = pst.executeQuery();

            while(rs.next()){
                level = rs.getInt("LEVEL");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeDatabaseConnection();
        return level;
    }

    public int retrieveScore(String username){
        openDatabaseConnection();
        int score = 0;
        String sql = "SELECT TOTALSCORE FROM " + TABLE_NAME + " WHERE USERNAME = ?";
        ResultSet rs = null;
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,username);
            rs = pst.executeQuery();

            while(rs.next()){
                score = rs.getInt("TOTALSCORE");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeDatabaseConnection();
        return score;
    }

    //return user array
    public User[] fillLeaderBoard(User[]userArray){
        openDatabaseConnection();

        int index = 0;
        String sql = "SELECT* FROM " + TABLE_NAME;
        ResultSet rs = null;

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String username = rs.getString("USERNAME");
                int lastLevelPassed = rs.getInt("LEVEL");
                int totalScore = rs.getInt("TOTALSCORE");

                User newUser = new User();
                newUser.setUsername(username);
                newUser.setLastPassedLevel(lastLevelPassed);
                newUser.setScore(totalScore);
                userArray[index] = newUser;
                index++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeDatabaseConnection();
        return userArray;
    }
}

