package com.example.Buyogo_Assessment.Transformer;

import com.example.Buyogo_Assessment.Dto.RequestDto;
import com.example.Buyogo_Assessment.Model.Center;

public class TrainingCenterTransformer {

    public static Center RequestToCenter(RequestDto requestDto){
        return Center.builder()
                .phoneNo(requestDto.getPhoneNo())
                .centerName(requestDto.getCenterName())
                .course_Offered(requestDto.getCourse_Offered())
                .centerCode(requestDto.getCenterCode())
                .address(requestDto.getAddress())
                .email(requestDto.getEmail())
                .student_Capacity(requestDto.getStudent_Capacity())
                .build();
    }
}
