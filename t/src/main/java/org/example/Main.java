package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws SQLException {
//  vendor  host port database schema
        String url="jdbc:mysql://localhost:3306/matrimony_db";
        String username="root";
        String password = "Shivani@2025";

        try {
            Connection con =DriverManager.getConnection(url,username,password);
            System.out.println("Connection Successful");
            String sql = "insert into matrimony_form values(30,'anna@gmail.com','Female','Bride','2000-09-30','Hindi','Muslim','Single',7);";
            Statement statement = con.createStatement();
            int rowsAffected = statement.executeUpdate(sql);
            System.out.println("Number of rows affected " + rowsAffected);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}

