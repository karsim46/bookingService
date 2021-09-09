package com.codeclan.example.bookingService.components;

import com.codeclan.example.bookingService.models.Booking;
import com.codeclan.example.bookingService.models.Course;
import com.codeclan.example.bookingService.models.Customer;
import com.codeclan.example.bookingService.repositories.BookingRepository;
import com.codeclan.example.bookingService.repositories.CourseRepository;
import com.codeclan.example.bookingService.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args){

        Customer customer1 = new Customer("David", "Brown", "Peebles", 32);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Simon", "Watson", "Ellon", 39);
        customerRepository.save(customer2);

        Course course1 = new Course("Intro to Python", "Edinburgh", 4);
        courseRepository.save(course1);

        Course course2 = new Course("Javascript React", "Glasgow", 5);
        courseRepository.save(course2);

        Course course3 = new Course("RESTApi", "Edinburgh", 3);
        courseRepository.save(course3);

        Course course4 = new Course("TDD", "Glasgow", 1);
        courseRepository.save(course4);

        Booking booking1 = new Booking("9/9/21", customer1, course1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("9/10/21", customer2, course2);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("11/9/21", customer1, course3);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("9/9/21", customer2, course4);
        bookingRepository.save(booking4);
    }
}
