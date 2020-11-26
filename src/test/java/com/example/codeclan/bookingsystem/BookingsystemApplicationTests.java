package com.example.codeclan.bookingsystem;

import com.example.codeclan.bookingsystem.models.Booking;
import com.example.codeclan.bookingsystem.models.Course;
import com.example.codeclan.bookingsystem.models.Customer;
import com.example.codeclan.bookingsystem.repositories.BookingRepository;
import com.example.codeclan.bookingsystem.repositories.CourseRepository;
import com.example.codeclan.bookingsystem.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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

	@Test
	public void canFindBookingByDate(){
		List<Booking> foundBooking = bookingRepository.findByDate("26-11-20");
		assertEquals(2, foundBooking.size());
		assertEquals("26-11-20", foundBooking.get(0).getDate());
	}

	@Test
	public void canFindCourseByRating(){
		List<Course> foundCourse = courseRepository.findByRating(4);
		assertEquals(1, foundCourse.size());
		assertEquals(4, foundCourse.get(0).getRating());
	}

	@Test
	public void  canFindCourseByCustomerName(){
		List<Course> foundCourse = courseRepository.findByBookingsCustomerName("Cam");
		assertEquals(2, foundCourse.size());
		assertEquals("Intro to Spring", foundCourse.get(0).getName());
		assertEquals("Intro to Java", foundCourse.get(1).getName());
	}

	@Test
	public void canFindCustomersByCourse(){
		List<Customer> foundCustomer = customerRepository.findByBookingsCourseName("Intro to Spring");
		assertEquals(2, foundCustomer.size());
		assertEquals("Cam", foundCustomer.get(0).getName());
		assertEquals("David", foundCustomer.get(1).getName());
	}

	@Test
	public void canFindCustomersByTownAndCourse(){
		List<Customer> foundCustomer = customerRepository.findByBookingsCourseNameAndCustomerTown(
				"Intro to Spring", "Motherwell");
		assertEquals(1, foundCustomer.size());
		assertEquals("Cam", foundCustomer.get(0).getName());
		assertEquals("Motherwell", foundCustomer.get(0).getCustomerTown());
	}

	@Test
	public void canFindCustomersOlderThanAgeInCustomerTownForCourse(){
		List<Customer> foundCustomer = customerRepository.findByAgeGreaterThanAndCustomerTownAndBookingsCourseName(
				24, "Glasgow", "Intro to Java"
		);
		assertEquals(1, foundCustomer.size());
		assertEquals("Gregg", foundCustomer.get(0).getName());
		assertEquals(25, foundCustomer.get(0).getAge());
		assertEquals("Glasgow", foundCustomer.get(0).getCustomerTown());
	}

	@Test
	public void cannotFindCustomersOlderThanAgeInCustomerTownForCourse(){
		List<Customer> foundCustomer = customerRepository.findByAgeGreaterThanAndCustomerTownAndBookingsCourseName(
				40, "Glasgow", "Intro to Java"
		);
		assertEquals(0, foundCustomer.size());
	}


}
