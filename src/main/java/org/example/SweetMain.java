package org.example;

import org.example.DBConstant;

import java.sql.*;

public class SweetMain {
    public static void main(String[] args) throws SQLException {

        try {

            try (Connection connection = DriverManager.getConnection(
                    DBConstant.URL.getS(),
                    DBConstant.USERNAME.getS(),
                    DBConstant.SECRET.getS())
            ) {

                Statement statement = connection.createStatement();
                String selectResult = "select * from sweet";
                ResultSet result = statement.executeQuery(selectResult);

                while (result.next()) {
                    System.out.println(result.getString(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}