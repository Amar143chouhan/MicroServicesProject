package com.hotelserivce.controllers;

import com.hotelserivce.entities.Hotel;
import com.hotelserivce.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController
{

    @Autowired
    private  HotelService service;


    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody  Hotel hotel){

        Hotel h = service.createHotel(hotel);

        return  ResponseEntity.status(HttpStatus.CREATED).body(h);
    }


    @GetMapping("/{id}")
    public  ResponseEntity<Hotel> getHotelById(@PathVariable  String id ){

       Hotel h = service.getSingleHotel(id);
        return  ResponseEntity.ok(h);

    }


    @GetMapping
     public ResponseEntity<List<Hotel>> getAllHotels(){

        List<Hotel> list =service.getALlHotel();

    return  ResponseEntity.ok(list);
    }








}
