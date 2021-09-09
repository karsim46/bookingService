package com.codeclan.example.bookingService.repositories;

import com.codeclan.example.bookingService.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    //<bookings> - <date>
    List<Booking> findByDate(String date);
}
