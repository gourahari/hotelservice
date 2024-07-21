package com.goura.service.hotel.service.impl;

import com.goura.service.hotel.entity.Hotel;
import com.goura.service.hotel.exception.ResourceNotFoundException;
import com.goura.service.hotel.repository.HotelRepository;
import com.goura.service.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository repository;

    @Override
    public void createHotel(Hotel hotel) {
        UUID uuid = UUID.randomUUID();
        hotel.setId(String.format("%.16s%.16s",
                Math.abs(uuid.getMostSignificantBits()),
                Math.abs(uuid.getLeastSignificantBits())));
        repository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return repository.findAll();
    }

    @Override
    public Hotel getHotelById(String id) throws ResourceNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Hotel with id:%s not found.", id)
                ));
    }
}
