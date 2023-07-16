package com.ratingService.services;

import com.ratingService.entities.Rating;
import com.ratingService.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService
{

    @Autowired
   private RatingRepository repository;


    @Override
    public Rating create(Rating rating) {
        return repository.save(rating);
    }

    @Override
    public List<Rating> getRatings()
    {
        return repository.findAll();
    }

    @Override
    public List<Rating> getRatingByuserid(String userid)
    {
        return repository.findByuserid(userid);
    }

    @Override
    public List<Rating> getRatingByhotelid(String hotelid)
    {
        return repository.findByhotelid(hotelid);
    }
}
