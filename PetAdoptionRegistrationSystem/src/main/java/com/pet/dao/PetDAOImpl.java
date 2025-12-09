package com.pet.dao;

import com.pet.dto.PetAdaptionDTO;

import java.sql.*;
import java.util.Optional;

public class PetDAOImpl implements PetDAO {

    private static final String INSERT_SQL =
            "INSERT INTO adoption(name, city, petType, experience, phone) VALUES (?, ?, ?, ?, ?)";

    private static final String DUPLICATE_SQL =
            "SELECT COUNT(*) FROM adoption WHERE phone = ?";

    private static final String SEARCH_SQL =
            "SELECT * FROM adoption WHERE phone = ?";

    public PetDAOImpl() {
        System.out.println("PetDAOImpl created");
    }

    /* ---------------------- SAVE METHOD ---------------------------- */

    @Override
    public boolean save(PetAdaptionDTO dto) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // load driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        // Before saving → check duplicate
        if (isDuplicate(dto)) {
            System.out.println("Duplicate detected: Phone already exists");
            return false;
        }

        // Insert data
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/pet_db", "root", "Shivani@2025");
             PreparedStatement ps = con.prepareStatement(INSERT_SQL)) {

            ps.setString(1, dto.getName());
            ps.setString(2, dto.getCity());
            ps.setString(3, dto.getPetType());
            ps.setInt(4, dto.getExperience());
            ps.setString(5, dto.getPhone());

            System.out.println("Saving adoption record:");
            System.out.println("Name = " + dto.getName());
            System.out.println("Phone = " + dto.getPhone());

            int rows = ps.executeUpdate();
            System.out.println("Rows inserted: " + rows);

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    /* ---------------------- DUPLICATE CHECK ---------------------------- */

    @Override
    public boolean isDuplicate(PetAdaptionDTO dto) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // load driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/pet_db", "root", "Shivani@2025");
             PreparedStatement ps = con.prepareStatement(DUPLICATE_SQL)) {

            System.out.println("Checking duplicate for phone: " + dto.getPhone());

            ps.setString(1, dto.getPhone());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Duplicate count = " + count);
                return count > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    /* ------------------------ SEARCH BY PHONE ------------------------ */

    @Override
    public Optional<PetAdaptionDTO> findByPhone(String phoneNo) {

        System.out.println("Searching adoption by phone: " + phoneNo);

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/pet_db", "root", "Shivani@2025");
             PreparedStatement ps = con.prepareStatement(SEARCH_SQL)) {

            ps.setString(1, phoneNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Record found in DB...");

                PetAdaptionDTO dto = new PetAdaptionDTO(
                        rs.getString("name"),
                        rs.getString("city"),
                        rs.getString("petType"),
                        rs.getInt("experience"),
                        rs.getString("phone")
                );

                System.out.println("DTO from DB: " + dto);

                return Optional.of(dto);
            } else {
                System.out.println("No record found for phone: " + phoneNo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }


    /* -------------------- STATIC BLOCK ---------------------------- */

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL Driver Loaded!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
