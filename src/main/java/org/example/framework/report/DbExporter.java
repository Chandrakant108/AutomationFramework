package org.example.framework.report;

import java.sql.*;

public class DbExporter {

    private static final String URL = "jdbc:mysql://localhost:3306/automationframeworkdb";
    private static final String USER = "root";
    private static final String PASSWORD = "Ck@709136";

    public static void saveToDB(String testName, String status, float execTime, String timestamp) {
        String sql = "INSERT INTO TestResults (test_name, status, execution_time, timestamp) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, testName);
            pstmt.setString(2, status);
            pstmt.setFloat(3, execTime);
            pstmt.setString(4, timestamp);

            pstmt.executeUpdate();
            System.out.println("Test result exported to DB: " + testName + " | " + status + " | " + execTime + "s | " + timestamp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
