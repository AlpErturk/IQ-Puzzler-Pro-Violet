/*
 * Author: Elif Gulsah Kasdogan
 * Class: Connection Manager for Database Connection
 * Handles Connection Manager object will be used for database connection
 */
package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DATABASE CONNECTION MANAGER
public class ConnectionManager {
    private static String url;
    private static Connection connection;

    public ConnectionManager(){
        url = "jdbc:sqlite:C:/Users/alper/Desktop/database iq/loginDB.db"; //database url
        Connection connection = null;
    }

    public static Connection getConnection(){
        try{
            //System.out.println("in try block");
            try {
                Class.forName("org.sqlite.JDBC"); //driver name
                connection = DriverManager.getConnection(url);
            }catch(ClassNotFoundException e){
                System.out.println("Driver not found!" + e);
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return connection;
    }
}
