package com.example.IRCTC.Repository;

import com.example.IRCTC.Models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger, Integer> {

    public List<Passenger> findByDate(Date date);

    public List<Passenger> findByGender(String gender);
}
