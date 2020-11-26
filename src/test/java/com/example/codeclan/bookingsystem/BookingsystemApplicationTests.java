package com.example.codeclan.bookingsystem;

import com.example.codeclan.bookingsystem.models.Booking;
import com.example.codeclan.bookingsystem.models.Course;
import com.example.codeclan.bookingsystem.models.Customer;
import com.example.codeclan.bookingsystem.repositories.BookingRepository;
import com.example.codeclan.bookingsystem.repositories.CourseRepository;
import com.example.codeclan.bookingsystem.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookingsystemApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void canAddCustomerBookingAndCourse(){
//		Course course = new Course("Intro to Spring", "Glasgow", 4);
//		Customer customer = new Customer("David", "Glasgow", 21);
//		courseRepository.save(course);
//		customerRepository.save(customer);
//		Booking booking = new Booking("26-11-20", course, customer);
//		bookingRepository.save(booking);
//		assertEquals("Intro to Spring", courseRepository.getOne(1L).getName());
//		assertEquals("David", customerRepository.getOne(1L).getName());
//		assertEquals("26-11-20", bookingRepository.getOne(1L).getDate());
//	}

}
