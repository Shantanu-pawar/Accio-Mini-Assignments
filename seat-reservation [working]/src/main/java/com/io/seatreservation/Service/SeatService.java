package com.io.seatreservation.Service;

import com.io.seatreservation.DTOs.SeatEntryDTO;
import com.io.seatreservation.DTOs.TopRated5RequestDto;
import com.io.seatreservation.DTOs.UpdateSeatRequestDto;
import com.io.seatreservation.Models.Employee;
import com.io.seatreservation.Models.Seat;
import com.io.seatreservation.Repository.EmployeeRepo;
import com.io.seatreservation.Repository.SeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SeatService {

    @Autowired
    SeatRepo seatRepo;
    @Autowired
    EmployeeRepo employeeRepo;

    public String addSeat(SeatEntryDTO seatEntryDTO) throws Exception{
        // validation like emp id is present
        Optional<Employee> optional = employeeRepo.findById(seatEntryDTO.getEmployeeId());
        if(!optional.isPresent()){
            throw new Exception("this employee is not present");
        }

        // set it's attributes
        Seat seat = new Seat(seatEntryDTO.getDate(), seatEntryDTO.getReserved());

        // we've to set employee id differently.
        Employee employee = optional.get();
        seat.setEmployee(employee);

        // add the seat in that previous list
        List<Seat> seatList = employee.getSeatList();
        seatList.add(seat);

        // here saved the updated list
        employee.setSeatList(seatList);
        employeeRepo.save(employee);
        return "seat added successfully";
    }

    public List<TopRated5RequestDto> getEmployeesWhoBookedMoreSeats(){

        List<Employee> employeeList = employeeRepo.findAll();
        List<TopRated5RequestDto> dtoList = new ArrayList<>();

        for(Employee employee : employeeList){
            if(employee.getSeatList().size() >= 5){
//                TopRated5RequestDto topRated5RequestDto =
//                        new TopRated5RequestDto(employee.getEmployeeId(),employee.getName());
//
                dtoList.add(new TopRated5RequestDto(employee.getEmployeeId(),employee.getName(),
                        employee.getSeatList().size()));
            }
        }
        return dtoList;
    }

    public String deleteAllReservedSeats(){
        List<Seat> seatList = seatRepo.findAll();

        for(Seat seat : seatList){
            if(Objects.equals(seat.getReserved(), "true")){
                seatRepo.deleteById(seat.getSeatNo());
            }
        }
        return "seat's who is booked are deleted successfully.";
    }

    public String deleteEmployees(){
        // find who has less booking below 4 seats
        List<Seat> seatList = seatRepo.getSeatWhoBookedLessThan5();

        List<Integer> employeeIds = seatList.stream().map(Seat::getEmployee)
                .map(Employee::getEmployeeId).distinct() // we're getting unique id's
                .collect(Collectors.toList());

        seatRepo.deleteAll(seatList);
        employeeIds.forEach(id -> employeeRepo.deleteById(id));

        return "successfully deleted all the employees who booked less than 5";
    }

    public String updateSeat(UpdateSeatRequestDto updateSeatRequestDto) throws Exception{
        // for seat validation check
        int seatNo = updateSeatRequestDto.getSeat_no();
        Optional<Seat> optionalSeat = seatRepo.findById(seatNo);

        if(!optionalSeat.isPresent()){
            throw new Exception("Seat is not available in Db check your seat number");
        }

        Seat seat = optionalSeat.get();
        seat.setDate(updateSeatRequestDto.getDate());
        seat.setReserved(updateSeatRequestDto.getReserved());

        int employeeId = updateSeatRequestDto.getEmployee_id();
        Optional<Employee> employee = employeeRepo.findById(employeeId);
        seat.setEmployee(employee.get());
        seat = seatRepo.save(seat);

        // now here we're setting the employee attributes and saved it
        Employee emp = employee.get();
        emp.setName(updateSeatRequestDto.getName());
        emp.setTeam(updateSeatRequestDto.getTeam());
        employeeRepo.save(emp);
        return "Seat updated successfully";
    }
}
