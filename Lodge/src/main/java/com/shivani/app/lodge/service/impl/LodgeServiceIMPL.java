package com.shivani.app.lodge.service.impl;

import com.shivani.app.lodge.dao.LodgeDAO;
import com.shivani.app.lodge.dao.impl.LodgeDAOIMPL;
import com.shivani.app.lodge.dto.LodgeDTO;
import com.shivani.app.lodge.dto.SearchDTO;
import com.shivani.app.lodge.exception.DataDuplicateException;
import com.shivani.app.lodge.exception.DataInvalidException;
import com.shivani.app.lodge.service.LodgeService;

import java.util.Optional;

public class LodgeServiceIMPL implements LodgeService {

    //We need to create the object for LodgeDAO to save the validated data in DAO
    private final LodgeDAO lodgeDAO = new LodgeDAOIMPL();
    //default constructor
    public LodgeServiceIMPL(){
        System.out.println("The LodgeServiceIMPL object has been invoked ");
    }
    @Override
    public boolean validateAndSave(LodgeDTO lodgeDTO) throws DataInvalidException , DataDuplicateException {

        String name = lodgeDTO.getName();
        long phoneNumber = lodgeDTO.getPhoneNumber();
        String  roomType = lodgeDTO.getRoomType();
        double totalAmount = lodgeDTO.getTotalAmount();
        String paymentStatus = lodgeDTO.getPaymentStatus();

        //Taken dummy variable for validation
        boolean isInvalid = false;

        if(name == null){
            isInvalid = true;
        } else if (phoneNumber == 0 ) {
            isInvalid = true;
        } else if (roomType == null) {
            isInvalid = true;
        } else if (totalAmount == 0) {
            isInvalid = true;
        } else if (paymentStatus == null ) {
            isInvalid = true ;
        }

        if (lodgeDAO.isDuplicate(lodgeDTO)){
            throw new DataDuplicateException("The phone number already exists");
        }
        if(isInvalid){
            throw new DataInvalidException("Please add the valid data");
        }
        boolean saved = lodgeDAO.save(lodgeDTO);
        System.out.println("The data has been validated and now the control goes to DAO" + saved );

        return saved;
    }
    @Override
    public Optional<LodgeDTO> findByPhone(SearchDTO searchDTO){
        long phoneNumber = searchDTO.getPhoneNumber();
        boolean isInvalid = false;
        if(phoneNumber == 0){
            isInvalid = true;
        }
        if (!isInvalid){
            Optional<LodgeDTO> lodgeDTO = this.lodgeDAO.findByPhone(phoneNumber);
            System.out.println("Optional lodge dto " + lodgeDTO.isPresent());
            return lodgeDTO;

        }
        return LodgeService.super.findByPhoneNumber(searchDTO);
    }


}
