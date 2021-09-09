package com.codeclan.example.bookingService.repositories;

import com.codeclan.example.bookingService.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // <bookings> <course> <name>
    List<Customer> findByBookingsCourseId(Long id);
    //<customer> - <town> - <course>
    List<Customer> findByTownAndBookingsCourseId(String town, Long id);
}
