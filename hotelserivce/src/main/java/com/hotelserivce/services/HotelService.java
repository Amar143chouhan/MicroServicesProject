package com.hotelserivce.services;

import com.hotelserivce.entities.Hotel;

import java.util.List;

public interface HotelService
{

    //create hotel
    Hotel createHotel(Hotel hotel);

    //get hotel
    List<Hotel> getALlHotel();


    //get single hotel
    Hotel getSingleHotel(String id);
}
