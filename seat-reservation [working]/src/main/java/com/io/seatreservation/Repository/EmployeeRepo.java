package com.io.seatreservation.Repository;

import com.io.seatreservation.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    @Query(value = "select emp.* from employee emp join seat s on " +
            "emp.employee_id = s.employee_employee_id group by emp.employee_id" +
            " having count(s.employee_employee_id) >=5",
    nativeQuery = true)
    public List<Employee> employeeList();


    public List<Employee> findByTeam(String team);
}

//
//select emp.* from employee emp
//join seat s on emp.employee_id = s.employee_employee_id
//group by emp.employee_id having count(s.employee_employee_id) >=5;


//
//select * from seat where employee_employee_id in(select id from
//        (select employee_employee_id as id, count(*) as booking from seat group by id  having booking < 5) as alice)