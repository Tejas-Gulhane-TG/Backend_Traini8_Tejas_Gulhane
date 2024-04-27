package com.example.Buyogo_Assessment.Repository;

import com.example.Buyogo_Assessment.Model.Center;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Center, Long> {
    Center findByPhoneNo(String phoneNo);
    Center findByEmail(String email);
    Center findByCenterCode(String centerCode);

}
