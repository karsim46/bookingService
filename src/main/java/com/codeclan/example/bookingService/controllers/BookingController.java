package com.codeclan.example.bookingService.controllers;

import com.codeclan.example.bookingService.models.Booking;
import com.codeclan.example.bookingService.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value="/bookings")
    public ResponseEntity<List<Booking>> findBookings(){
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }
}
