package com.ratingService.services;

import com.ratingService.entities.Rating;

import java.util.List;


public interface RatingService
{

    Rating create(Rating rating);

    List<Rating> getRatings();

    List<Rating> getRatingByuserid(String userid);


    List<Rating> getRatingByhotelid(String  hotelid);


}
