package com.ratingService.repository;

import com.ratingService.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,String>
{

    List<Rating> findByuserid(String userid);
    List<Rating> findByhotelid(String hotelid);



}
