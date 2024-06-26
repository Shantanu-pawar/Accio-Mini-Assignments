package com.io.seatreservation.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequestDto {

    private String name;
    private int durationInMinutes;
    private double imdbRating;

    //getting id from director
    private int directorId;
}
