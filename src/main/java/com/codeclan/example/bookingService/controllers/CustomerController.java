package com.codeclan.example.bookingService.controllers;

import com.codeclan.example.bookingService.models.Customer;
import com.codeclan.example.bookingService.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value="/customers")
    public ResponseEntity<List<Customer>> getCustomers(
            @RequestParam(name="course", required = false) Long id,
            @RequestParam(name="town", required = false) String town
            ){

        if(id!=null && town != null){
            return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourseId(town, id), HttpStatus.OK);
        }

        if (id != null){
            return new ResponseEntity<>(customerRepository.findByBookingsCourseId(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}

//    /courses?town="theTown"&course="id"