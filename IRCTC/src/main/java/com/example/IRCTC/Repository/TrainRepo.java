package com.example.IRCTC.Repository;

import com.example.IRCTC.Models.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepo extends JpaRepository<Train, Integer> {

}
