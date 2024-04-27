package com.example.Buyogo_Assessment.Service;

import com.example.Buyogo_Assessment.Dto.RequestDto;
import org.springframework.http.ResponseEntity;

public interface TrainingService {
    ResponseEntity CreateTrainingCenter(RequestDto requestDto);

    ResponseEntity GetCenters();
}
