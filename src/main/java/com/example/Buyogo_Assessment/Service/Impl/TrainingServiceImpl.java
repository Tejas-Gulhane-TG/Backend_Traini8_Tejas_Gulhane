package com.example.Buyogo_Assessment.Service.Impl;

import com.example.Buyogo_Assessment.Dto.RequestDto;
import com.example.Buyogo_Assessment.Exception.IsValid;
import com.example.Buyogo_Assessment.Model.Address;
import com.example.Buyogo_Assessment.Model.Center;
import com.example.Buyogo_Assessment.Repository.TrainingRepository;
import com.example.Buyogo_Assessment.Service.TrainingService;
import com.example.Buyogo_Assessment.Transformer.TrainingCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    TrainingRepository trainingRepository;
    @Override
    public ResponseEntity CreateTrainingCenter(RequestDto requestDto){

        // Check name is valid or not
        if(requestDto.getCenterName().length()>40){
            //return new ResponseEntity<>("Center name is greater than 40 Character",HttpStatus.NOT_ACCEPTABLE);
            throw new IsValid("Center name is greater than 40 Character");
        }

        // Check Center Code Valid
        if(requestDto.getCenterCode().length()>12 || requestDto.getCenterCode().length()<12){
            //return new ResponseEntity<>("Center Code is Only 12 Character",HttpStatus.NOT_ACCEPTABLE);
            throw new IsValid("Center Code is Only 12 Character");
        }

        // Check Phone No Valid
        if(requestDto.getPhoneNo().length()>10 || requestDto.getPhoneNo().length()<10){
            //return new ResponseEntity<>("Invalid phone No",HttpStatus.NOT_ACCEPTABLE);
            throw new IsValid("Invalid phone No");
        }

        // Transform RequestDto To Center
        Center center = TrainingCenterTransformer.RequestToCenter(requestDto);
        Center center1 = trainingRepository.findByPhoneNo(center.getPhoneNo());
        Center center2 =trainingRepository.findByEmail(center.getEmail());
        Center center3 =trainingRepository.findByCenterCode(center.getCenterCode());

        // Check Phone No is Already use
        if(center1 != null){
            //return new ResponseEntity("Phone no Already Use ", HttpStatus.NOT_ACCEPTABLE);
            throw new IsValid("Phone no Already Use");
        }

        // Check Email id Already Use
        if(center2 != null){
            //return new ResponseEntity("Email id Already Use ", HttpStatus.NOT_ACCEPTABLE);
            throw new IsValid("Email Id Already Use");
        }

        // Check Center Code Already Use
        if(center3 != null){
            //return new ResponseEntity("Center Code Already Use ", HttpStatus.NOT_ACCEPTABLE);
            throw new IsValid("Center Code Already Use");
        }


        // Check Email id Valid Or not
        String email = center.getEmail();
        boolean flag = false;
        for(int i=0; i<email.length(); i++){
            if(email.charAt(i)=='@'){
                flag = true;
            }
        }
        if(flag == false){
            //return new ResponseEntity("Invalid Email id", HttpStatus.NOT_ACCEPTABLE);
            throw new IsValid("Invalid Email Id");
        }


        // Check Address is Valid
        Address address = center.getAddress();
        if(address.getCity()==null || address.getDetailedAddress()==null || address.getState()==null || address.getPinCode()==null){
            throw new IsValid("Add full Address");
        }


        // Save The New Center
        trainingRepository.save(center);
        return new ResponseEntity(center, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity GetCenters() {
        List<Center> centerList = new ArrayList<>();
        centerList = trainingRepository.findAll();
        return new ResponseEntity<>(centerList, HttpStatus.OK);
    }
}
