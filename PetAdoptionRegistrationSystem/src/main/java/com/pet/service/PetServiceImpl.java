package com.pet.service;

import com.pet.dao.PetDAO;
import com.pet.dao.PetDAOImpl;
import com.pet.dto.PetAdaptionDTO;
import com.pet.dto.SearchDTO;
import com.pet.exception.DataInvalidException;

import java.util.Optional;

public class PetServiceImpl implements PetService {

    private final PetDAO petDAO = new PetDAOImpl();

    public PetServiceImpl() {
        System.out.println("PetServiceImpl created");
    }

    @Override
    public boolean validateAndSave(PetAdaptionDTO dto)
            throws Exception {

        String name = dto.getName();
        String city = dto.getCity();
        String petType = dto.getPetType();
        Integer experience = dto.getExperience();
        String phone = dto.getPhone();

        boolean invalid = isInvalid(dto, name, city, petType, experience, phone);

        if (invalid) {
            throw new DataInvalidException("The provided adoption data is not valid");
        }

        // Duplicate check (same style as fish)
        if (petDAO.isDuplicate(dto)) {
            System.out.println("Duplicate entry detected for phone: " + phone);
            return false;
        }

        boolean saved = petDAO.save(dto);
        System.out.println("Pet adoption data saved: " + saved);
        return saved;
    }



    private boolean isInvalid(PetAdaptionDTO dto, String name, String city, String petType,
                              Integer experience, String phone) {

        boolean invalid = false;

        if (name == null || name.length() < 3) {
            invalid = true;
        } else if (city == null || city.length() < 3) {
            invalid = true;
        } else if (petType == null || petType.length() < 3) {
            invalid = true;
        } else if (experience == null || experience < 0) {
            invalid = true;
        } else if (phone == null || phone.length() != 10) {
            invalid = true;
        }

        return invalid;
    }


    @Override
    public Optional<PetAdaptionDTO> findByPhone(SearchDTO searchDTO) {

        String phone = searchDTO.getPhone();
        boolean invalid = false;

        if (phone == null || phone.length() != 10) {
            System.err.println("Invalid phone number for search");
            invalid = true;
        }

        if (!invalid) {
            System.out.println("Phone is valid, calling DAO...");
            Optional<PetAdaptionDTO> optional = petDAO.findByPhone(phone);
            System.out.println("Search result found: " + optional.isPresent());
            return optional;
        }

        return Optional.empty();
    }
}
