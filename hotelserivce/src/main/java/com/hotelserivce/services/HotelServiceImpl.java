package com.hotelserivce.services;

import com.hotelserivce.entities.Hotel;
import com.hotelserivce.exception.ResourceNotFoundException;
import com.hotelserivce.repositories.hotelrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
  public class HotelServiceImpl implements  HotelService
  {
    @Autowired
    private hotelrepo repo;

    @Override
    public Hotel createHotel(Hotel hotel)
    {
        String hotelid =  UUID.randomUUID().toString();
        hotel.setId(hotelid);
        return repo.save(hotel);
    }

    @Override
    public List<Hotel> getALlHotel()
    {
        return repo.findAll();
    }

    @Override
    public Hotel getSingleHotel(String id)
    {
        return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel with the given id is not found"));
    }
}
