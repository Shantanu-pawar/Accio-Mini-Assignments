package com.io.seatreservation.Service;

import com.io.seatreservation.DTOs.FindEmployeesWorkedInSameTeam;
import com.io.seatreservation.Models.Employee;
import com.io.seatreservation.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public String addEmployee(Employee employee){
        employeeRepo.save(employee);
        return "employee saved";
    }

    public List<FindEmployeesWorkedInSameTeam> findEmployees(String team){

        List<Employee> employeeList = employeeRepo.findAll();
        List<FindEmployeesWorkedInSameTeam> dtoList = new ArrayList<>();

        for(Employee employee : employeeList){
            if(Objects.equals(employee.getTeam(), team)){
                FindEmployeesWorkedInSameTeam find = new FindEmployeesWorkedInSameTeam();

                find.setTeam(employee.getTeam());
                find.setName(employee.getName());
                find.setEmployeeId(employee.getEmployeeId());

                dtoList.add(find);
            }
        }
        return dtoList;
    }


    public String updateTeams(String fromTeam,String toTeam) throws Exception{

        List<Employee> employeeList = employeeRepo.employeeList();
        for(Employee employee : employeeList){

            if(employee.getTeam().equals(fromTeam)) {
                employee.setTeam(toTeam);
                employeeRepo.save(employee);
            }
        }

//        List<Employee> employeeList = employeeRepo.findAll();
//        for(Employee employee : employeeList){
//
//            if(employee.getSeatList().size() >= 5 && employee.getTeam().equals(fromTeam)) {
//                employee.setTeam(toTeam);
//                employeeRepo.save(employee);
//            }
//        }
        return "All employees who booked more than 5 seats are successfully promoted to another team";
    }


}
