package com.example.Buyogo_Assessment.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    String centerName;

    @Column(nullable = false)
    String centerCode;

    @Embedded
    Address address;

    @Column(nullable = false)
    int student_Capacity;

    @ElementCollection
    List<String> course_Offered = new ArrayList<>();

    @CreationTimestamp
    Date CreatedOn;

    @Column(unique = true)
    String email;

    @Column(nullable = false, unique = true)
    String phoneNo;

}


