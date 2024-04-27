package com.example.Buyogo_Assessment.Controller;

import com.example.Buyogo_Assessment.Dto.RequestDto;
import com.example.Buyogo_Assessment.Exception.IsValid;
import com.example.Buyogo_Assessment.Service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/training/centers")
public class TrainingController {

    @Autowired
    TrainingService trainingService;



//    Create A new Center
    @PostMapping("/create")
    public ResponseEntity CreateCenter(@RequestBody RequestDto requestDto) {
        try {
            ResponseEntity responseEntity = trainingService.CreateTrainingCenter(requestDto);
            return responseEntity;
        }
        catch (IsValid e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }


//    Get All Centers With Information
    @GetMapping("/get")
    public ResponseEntity GetCenters(){
        ResponseEntity responseEntity = trainingService.GetCenters();
        return responseEntity;
    }
}
