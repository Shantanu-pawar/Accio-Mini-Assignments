package com.example.IRCTC.Controller;

import com.example.IRCTC.Models.Train;
import com.example.IRCTC.RequestDto.AddPassengerDto;
import com.example.IRCTC.RequestDto.FemalePassengerDto;
import com.example.IRCTC.RequestDto.FindTrainWhoBookedMaxSeats;
import com.example.IRCTC.RequestDto.GetPassengerDTO;
import com.example.IRCTC.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passenger")

public class PassengerController {
    @Autowired
    PassengerService passengerService;

    @PostMapping("/add")
    public ResponseEntity<String> addPassenger(@RequestBody AddPassengerDto passenger){
        try{
            String response = passengerService.addPassenger(passenger);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getPassengerList")
    public ResponseEntity<String> getPassengers(@RequestBody GetPassengerDTO getPassengerDTO){
        int list = passengerService.getPassengers(getPassengerDTO);
        return new ResponseEntity(list, HttpStatus.OK);
    }


    @GetMapping("/getFemales")
    public ResponseEntity<String> getPassengers(@RequestBody FemalePassengerDto getPassengerDTO){
        int list = passengerService.findNoOfFemalePassengers(getPassengerDTO);
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/getTrainWhoBookedMaxSeats")
    public ResponseEntity<String> getPassengers(@RequestBody FindTrainWhoBookedMaxSeats get){
        Train train = passengerService.getMaxTrainSeats(get);
        return new ResponseEntity(train, HttpStatus.OK);
    }

}
