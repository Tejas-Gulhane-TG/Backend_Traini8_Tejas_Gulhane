package com.example.Buyogo_Assessment.Dto;

import com.example.Buyogo_Assessment.Model.Address;
import jakarta.persistence.ElementCollection;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestDto {

    String centerName;

    String centerCode;

    Address address;

    int student_Capacity;

    @ElementCollection
    List<String> course_Offered = new ArrayList<>();

    String email;

    String phoneNo;
}
