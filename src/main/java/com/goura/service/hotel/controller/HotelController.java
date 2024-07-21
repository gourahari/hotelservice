package com.goura.service.hotel.controller;

import com.goura.service.hotel.entity.Hotel;
import com.goura.service.hotel.exception.ResourceNotFoundException;
import com.goura.service.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService service;

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody Hotel hotel) {
        service.createHotel(hotel);
        return ResponseEntity.ok().body(String.format("Created with id: %s", hotel.getId()));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAll() {
        return ResponseEntity.ok().body(service.getAllHotels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getById(@PathVariable String id) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(service.getHotelById(id));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    // write a feign client to call this service from another service
    // write a test case to test this controller
    // write a test case to test the service
    // write a test case to test the repository
    // write a test case to test the entity
    
}
