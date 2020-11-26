package com.example.codeclan.bookingsystem.components;

import com.example.codeclan.bookingsystem.models.Booking;
import com.example.codeclan.bookingsystem.models.Course;
import com.example.codeclan.bookingsystem.models.Customer;
import com.example.codeclan.bookingsystem.repositories.BookingRepository;
import com.example.codeclan.bookingsystem.repositories.CourseRepository;
import com.example.codeclan.bookingsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.awt.print.Book;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args) {

//        Courses
        Course course1 = new Course("Intro to Spring", "Glasgow", 5);
        Course course2 = new Course("Intro to Java", "Glasgow", 4);
        Course course3 = new Course("Python for Dummies", "Edinburgh", 5);
        Course course4 = new Course("HTML 101", "Stirling", 3);
        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);
        courseRepository.save(course4);

//        Customers
        Customer customer1 = new Customer("Cam", "Motherwell", 25);
        Customer customer2 = new Customer("David", "Glasgow", 21);
        Customer customer3 = new Customer("Gregg", "Glasgow", 25);
        Customer customer4 = new Customer("Bob", "Stirling", 30);
        Customer customer5 = new Customer("Alicia", "Edinburgh", 23);
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);

//        Bookings
        Booking booking1 = new Booking("26-11-20", course1, customer1);
        Booking booking2 = new Booking("26-11-20", course1, customer2);
        Booking booking3 = new Booking("05-12-20", course2, customer1);
        Booking booking4 = new Booking("25-12-20", course2, customer3);
        Booking booking5 = new Booking("01-01-21", course3, customer2);
        Booking booking6 = new Booking("01-01-21", course3, customer3);
        Booking booking7 = new Booking("01-01-21", course3, customer4);
        Booking booking8 = new Booking("10-01-21", course4, customer2);
        Booking booking9 = new Booking("20-01-21", course4, customer5);
        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
        bookingRepository.save(booking4);
        bookingRepository.save(booking5);
        bookingRepository.save(booking6);
        bookingRepository.save(booking7);
        bookingRepository.save(booking8);
        bookingRepository.save(booking9);







    }
}
