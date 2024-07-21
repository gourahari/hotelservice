package com.goura.service.hotel.service;

import com.goura.service.hotel.entity.Hotel;
import com.goura.service.hotel.exception.ResourceNotFoundException;

import java.util.List;

public interface HotelService {
    // Create
    void createHotel(Hotel hotel);

    // List
    List<Hotel> getAllHotels();

    // Get One
    Hotel getHotelById(String id) throws ResourceNotFoundException;
}
