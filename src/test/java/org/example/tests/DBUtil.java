package org.example.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb2";
    private static final String USER = "root";         // change if needed
    private static final String PASSWORD = "Ck@709136"; // change to your MySQL root password

    // Each call returns a new connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Close connection safely
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Failed to close DB connection: " + e.getMessage());
            }
        }
    }
}
