package com.io.seatreservation.Repository;

import com.io.seatreservation.Models.Employee;
import com.io.seatreservation.Models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepo extends JpaRepository<Seat, Integer> {

    @Query(value = "select * from seat where employee_employee_id in(select id from (select employee_employee_id " +
            "as id, count(*) as booking from seat group by id having booking >= 5) as alice)",
            nativeQuery = true)
    public List<Seat> getEmployeesWhoBooked5Seats();

    // find employees who booked seats less than 5 count and delete it
    @Query(value = "select * from seat where employee_employee_id in(select id from (select employee_employee_id as id," +
            " count(*) as booking from seat group by id  having booking < 5) as alice)",
            nativeQuery = true)
    public List<Seat> getSeatWhoBookedLessThan5();



}

