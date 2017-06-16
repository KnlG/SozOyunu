package com.konulgurbanli.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Konul Gurbanli on 6/5/2017.
 */
class ConnectionManager {

    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String driverName = "oracle.jdbc.driver.OracleDriver";
    private static String username = "konul";
    private static String password = "asdfg123";
    private static Connection con = null;
    private static String urlstring;

    public static Connection getConnection() {
//        if (con!= null){
//            return con;
//        }
//        else {
            try {
                //step1 load the driver class
                Class.forName(driverName);
                try {
                    //step2 create  the connection object
                    con = DriverManager.getConnection(url, username, password);
                } catch (SQLException ex) {
                    // log an exception. for example:
                    System.out.println("Failed to create the database connection.");
                }
            } catch (ClassNotFoundException ex) {
                // log an exception. for example:
                System.out.println("Driver not found.");
            }
            return con;
//        }
    }
}

