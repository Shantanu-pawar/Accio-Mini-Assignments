package com.io.seatreservation.Controllers;

import com.io.seatreservation.DTOs.FindEmployeesWorkedInSameTeam;
import com.io.seatreservation.Models.Employee;
import com.io.seatreservation.Service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
        String response = employeeService.addEmployee(employee);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // API: find all employees who're working in the same team
    @GetMapping("/find-Who-Work-in-one-team/{team}")
    public List<FindEmployeesWorkedInSameTeam> findEmployees(@PathVariable("team") String team){
        return employeeService.findEmployees(team);
    }

//  update all employees team by the employees who actually booked seats more than 5
    @PutMapping("/updateTeam")
    public ResponseEntity<String> updateTeams(@RequestParam("fromTeam") String fromTeam,
                                              @RequestParam("toTeam") String toTeam){
        try {
            String response = employeeService.updateTeams(fromTeam, toTeam);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
