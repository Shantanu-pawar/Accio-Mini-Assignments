package com.io.seatreservation.Controllers;

import com.io.seatreservation.DTOs.SeatEntryDTO;
import com.io.seatreservation.DTOs.TopRated5RequestDto;
import com.io.seatreservation.DTOs.UpdateSeatRequestDto;
import com.io.seatreservation.Models.Employee;
import com.io.seatreservation.Models.Seat;
import com.io.seatreservation.Service.SeatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seat")
@Slf4j
public class SeatController {

    @Autowired
    SeatService seatService;

    @PostMapping("/add")
    public ResponseEntity<String> addSeat(@RequestBody SeatEntryDTO seat){
        try{
            String response =  seatService.addSeat(seat);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            log.error("seat not able to saved for particular employee" + e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    // Find the number of employees who booked seats more than 4 times. first return obj then return count
    @GetMapping("/getEmployees-WhoBooked-at-least-5Seats")
    public List<TopRated5RequestDto> getTop5(){
        //
        return seatService.getEmployeesWhoBookedMoreSeats();
    }

    // API : delete all reserved seats from DB
    @DeleteMapping("/deleteReservedSeats")
    public ResponseEntity<String> deleteAllReservedSeats(){
        String response = seatService.deleteAllReservedSeats();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // delete all employee who booked seats less than 4 times and also delete booked seats
    @DeleteMapping("/deleteAllEmployeesWhoBookedLessSeats")
    public ResponseEntity<String> deleteEmployees(){
        String response = seatService.deleteEmployees();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // update whole seat entity and also update employee with the help of using seatId

    /*problems i've facing : i want to get update on particular seat number but it created new one*/
    @PutMapping("/update-seat")
    public ResponseEntity<String> updateSeat(@RequestBody UpdateSeatRequestDto updateSeatRequestDto){
        try {
            String response = seatService.updateSeat(updateSeatRequestDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
