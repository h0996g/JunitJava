//package com.company;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class OracleConnection {
//    public static void main(String[] args) {
//        // JDBC URL, username, and password of Oracle database
//        String url = "jdbc:oracle:thin:@localhost:1521:XE";
//        String user = "sys as sysdba";
//        String password = "dalila13";
//
//        // JDBC variables for opening, closing, and managing Oracle connections
//        Connection connection = null;
//
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//
//            // Create a connection to the database
//            connection = DriverManager.getConnection(url, user, password);
//
//            // Perform database operations here
//
//            System.out.println("Connected to the Oracle database!");
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                // Close the connection in the finally block to ensure it's always closed
//                if (connection != null && !connection.isClosed()) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//
//
//    }
//
//}




package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {

    public static Connection getConnection(String jdbcUrl, String username, String password) throws SQLException {
        // Load the Oracle JDBC driver
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Create a connection to the database
        return DriverManager.getConnection(jdbcUrl, username, password);
    }

    public static void closeConnection(Connection connection) {
        try {
            // Close the connection if it's not null and not closed
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
