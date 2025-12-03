package com.pet.dao;

import com.pet.dto.PetAdaptionDTO;

import java.sql.*;

public class PetDAOImpl implements PetDAO{
    @Override
    public boolean save(PetAdaptionDTO petAdaptionDTO) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/pet_db";
        String username = "root";
        String password = "Shivani@2025";
        String sql = "insert into adoption (name , city, phone , experience , petType) Values (? ,? , ? , ? , ?)";

        try(Connection connection = DriverManager.getConnection(url , username , password)){
            Class.forName("com.mysql.cj.jdbc.Driver");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,petAdaptionDTO.getName());
            preparedStatement.setString(2,petAdaptionDTO.getCity());
            preparedStatement.setString(3,petAdaptionDTO.getPhone());
            preparedStatement.setInt(4,petAdaptionDTO.getExperience());
            preparedStatement.setString(5,petAdaptionDTO.getPetType());


            int row = preparedStatement.executeUpdate();
            return row > 0;
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
