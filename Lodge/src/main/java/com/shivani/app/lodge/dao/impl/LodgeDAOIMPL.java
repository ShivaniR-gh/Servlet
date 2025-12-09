package com.shivani.app.lodge.dao.impl;

import com.shivani.app.lodge.dao.DBConstant;
import com.shivani.app.lodge.dao.LodgeDAO;
import com.shivani.app.lodge.dto.LodgeDTO;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.Optional;

public class LodgeDAOIMPL implements LodgeDAO {


    public LodgeDAOIMPL(){
        System.out.println("The object created for LodgeDAOIMPL");
    }

    @Override
    public boolean save(LodgeDTO lodgeDTO) {

        //loads the MySQL JDBC driver into memory
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // load driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        String sql = "INSERT INTO lodge (name, phone_number, room_type, total_amount, payment_status) VALUES (?, ?, ?, ?, ?)";
        try(Connection connection = DriverManager.getConnection(
                DBConstant.URL.getS(),DBConstant.USERNAME.getS(),DBConstant.PASSWORD.getS())) {

           // PreparedStatement is used to pass values safely
           PreparedStatement preparedStatement = connection.prepareStatement(sql);

           //Sets the  values from DTO into the SQL query
           preparedStatement.setString(1 , lodgeDTO.getName());
           preparedStatement.setLong(2,lodgeDTO.getPhoneNumber());
           preparedStatement.setString(3 , lodgeDTO.getRoomType());
           preparedStatement.setDouble(4 , lodgeDTO.getTotalAmount());
           preparedStatement.setString(5, lodgeDTO.getPaymentStatus());

            System.out.println("Saving into the database");
            System.out.println("The residential name : " + lodgeDTO.getName());
            System.out.println("The residential phone number : " + lodgeDTO.getPhoneNumber());

            //Must be inside try block
            int rows = preparedStatement.executeUpdate();
            System.out.println("The number of rows changed is " + rows);

            //If ≥ 1 rows inserted → return true
            //If 0 → return false
            // This value goes back to service layer
            return rows > 0;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isDuplicate(LodgeDTO lodgeDTO) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }

        //Checks how many rows exist with the same phone number.
        String query = "Select count(*) from lodge where phone_number = ? ";
        try(Connection connection = DriverManager.getConnection(DBConstant.URL.getS() , DBConstant.USERNAME.getS(), DBConstant.PASSWORD.getS())){

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1 , lodgeDTO.getPhoneNumber());

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet.next()){
                    int count = resultSet.getInt(1);
                    System.out.println("The number of rows are : " + count);
                    return count > 0 ;
                }
            }


        }catch (SQLException e){
            e.printStackTrace();

        }
        return false;
    }

    @Override
    @SneakyThrows
    public Optional<LodgeDTO> findByPhone(long phoneNumber){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load driver
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        String sqlQuery = "Select * from lodge where phone_number = ? ";
        try(Connection connection = DriverManager.getConnection(DBConstant.URL.getS(), DBConstant.USERNAME.getS(),DBConstant.PASSWORD.getS())){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setLong(1,phoneNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println("The Phone number found in the database");

                String name = resultSet.getString("name");
                long phone = resultSet.getLong("phone_number");
                String roomType = resultSet.getString("room_type");
                double totalAmount = resultSet.getDouble("total_amount");
                String paymentStatus = resultSet.getString("payment_status");


                LodgeDTO lodgeDTO = new LodgeDTO(name , phone , roomType ,  totalAmount , paymentStatus );
                return Optional.of(lodgeDTO);

            }

            return Optional.empty();

        }
//        catch (SQLException e){
//            e.printStackTrace();
//        } sneaky throw manges the catchblock

    }
}
