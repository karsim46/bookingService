package com.codeclan.example.bookingService;

import com.codeclan.example.bookingService.models.Booking;
import com.codeclan.example.bookingService.models.Course;
import com.codeclan.example.bookingService.models.Customer;
import com.codeclan.example.bookingService.repositories.BookingRepository;
import com.codeclan.example.bookingService.repositories.CourseRepository;
import com.codeclan.example.bookingService.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookingServiceApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canAddCourse(){

		Customer testCustomer = new Customer("Simon", "Watson", "Ellon", 39);
		Course testCourse = new Course("Intro To Python", "Edinburgh", 4);
		Booking testBooking = new Booking("9/9/21", testCustomer, testCourse);

		customerRepository.save(testCustomer);
		courseRepository.save(testCourse);
		bookingRepository.save(testBooking);

		assertEquals("Simon", customerRepository.getById(1L).getFirstName());
		assertEquals("Edinburgh", courseRepository.getById(1L).getTown());
		assertEquals("9/9/21", bookingRepository.getById(1L).getDate());

		assertEquals(1, courseRepository.getById(1L).getBookings().size());
	}
}
