package com.example.IRCTC.Service;

import com.example.IRCTC.Models.Train;
import com.example.IRCTC.Repository.TrainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainService {

    @Autowired
    TrainRepo trainRepo;
    public String addTrain(Train train){
        trainRepo.save(train);
        return "train added successfully";
    }

}
