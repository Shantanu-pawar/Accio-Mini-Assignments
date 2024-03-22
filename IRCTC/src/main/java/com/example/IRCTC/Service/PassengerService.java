package com.example.IRCTC.Service;

import com.example.IRCTC.Models.Passenger;
import com.example.IRCTC.Models.Train;
import com.example.IRCTC.Repository.PassengerRepo;
import com.example.IRCTC.Repository.TrainRepo;
import com.example.IRCTC.RequestDto.AddPassengerDto;
import com.example.IRCTC.RequestDto.FemalePassengerDto;
import com.example.IRCTC.RequestDto.FindTrainWhoBookedMaxSeats;
import com.example.IRCTC.RequestDto.GetPassengerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired private PassengerRepo passengerRepo;
    @Autowired private TrainRepo trainRepo;

    public String addPassenger(AddPassengerDto dto){

        Optional<Train> optionalTrain = trainRepo.findById(dto.getTrainId());
        if(!optionalTrain.isPresent()){
            return "Train id is not available for booking.Enter another one : ";
        }

        Passenger passenger = new Passenger(dto.getTicketId(), dto.getDate(),
                dto.getAge(), dto.getGender());
        // now set the train into passenger and save it.
        passenger.setTrain(optionalTrain.get());

        passengerRepo.save(passenger);

        // save the passenger in ticket list and also in repo
        return "passenger added successful";
    }

    // API - getting list of passengers travelling from a to b on Date D
    public int getPassengers(GetPassengerDTO getPassengerDTO){

        List<Passenger> list = passengerRepo.findByDate(getPassengerDTO.getDate());
        List<Passenger> getPassenger = new ArrayList<>();
        int count = 0;

        String start = getPassengerDTO.getStarted();
        String end = getPassengerDTO.getDestination();

        for(Passenger passenger : list){
            if(passenger.getTrain().getStartPoint().equals(start) &&
                    passenger.getTrain().getDestination().equals(end) ) {

                count++;
            }
        }
        return count;
    }


    // api 1 - find the difference between age
    public int findNoOfFemalePassengers(FemalePassengerDto femalePassengerDto){

        List<Passenger> list = passengerRepo.findByGender(femalePassengerDto.getGender());
        int count = 0;

        for(Passenger passenger : list){
            int x = femalePassengerDto.getX();
            int y = femalePassengerDto.getY();
            String destination = femalePassengerDto.getDestination();
            if(x <= y && passenger.getTrain().getDestination().equals(destination)){
                count++;
            }
        }
        return count;
    }

    public Train getMaxTrainSeats(FindTrainWhoBookedMaxSeats findTrainWhoBookedMaxSeats){
        int trainId = 0;
        List<Passenger> list = passengerRepo.findAll();

        for(Passenger passenger : list){
            int getSize = passenger.getTrain().getPassengerList().size();

            Date date = findTrainWhoBookedMaxSeats.getDate();

            if( getSize > trainId && passenger.getDate().equals(date)) {
                trainId = passenger.getTrain().getTrainId();
            }
        }

        // finding and returning the max passengers
        Optional<Train> train = trainRepo.findById(trainId);
        return train.get();
    }

}
