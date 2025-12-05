package com.pet.dao;

import com.pet.dto.PetAdaptionDTO;

import java.sql.*;

public class PetDAOImpl implements PetDAO{
    @Override
    public boolean save(PetAdaptionDTO petAdaptionDTO) {

        String url = "jdbc:mysql://localhost:3306/pet_db";
        String username = "root";
        String password = "Shivani@2025";

        String checkSql = "SELECT 1 FROM adoption WHERE phone = ? LIMIT 1";
        String insertSql = "INSERT INTO adoption (name, city, phone, experience, petType) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            PreparedStatement checkStmt = connection.prepareStatement(checkSql);
            checkStmt.setString(1, petAdaptionDTO.getPhone());
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                return false;
            }

            PreparedStatement ps = connection.prepareStatement(insertSql);
            ps.setString(1, petAdaptionDTO.getName());
            ps.setString(2, petAdaptionDTO.getCity());
            ps.setString(3, petAdaptionDTO.getPhone());
            ps.setInt(4, petAdaptionDTO.getExperience());
            ps.setString(5, petAdaptionDTO.getPetType());

            int row = ps.executeUpdate();
            return row > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}


