package com.ratingService.controllers;
import com.ratingService.services.RatingService;
import com.ratingService.entities.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController
{
    @Autowired
    private RatingService service;



    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings()

    {
        return  ResponseEntity.ok(service.getRatings());
    }

    @GetMapping("users/{userid}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userid)
    {
        return (ResponseEntity<List<Rating>>)
                ResponseEntity.ok(service.getRatingByuserid(userid));
    }

    @GetMapping("hotels/{hotelid}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelid)
    {
        return (ResponseEntity<List<Rating>>) ResponseEntity.ok(service.getRatingByhotelid(hotelid));

    }
}
