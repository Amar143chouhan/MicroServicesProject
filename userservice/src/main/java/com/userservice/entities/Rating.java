package com.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating
{
    private String ratingid;
    private String userid;
    private String hotelid;
    private int     rating;
     private String feedback ;
     private Hotel hotel;
}
