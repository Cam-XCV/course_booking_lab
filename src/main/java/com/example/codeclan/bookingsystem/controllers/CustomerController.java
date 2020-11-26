package com.example.codeclan.bookingsystem.controllers;

import com.example.codeclan.bookingsystem.models.Course;
import com.example.codeclan.bookingsystem.models.Customer;
import com.example.codeclan.bookingsystem.repositories.CustomerRepository;
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

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomersWithFilters(
            @RequestParam(name="courseName", required = false) String courseName,
            @RequestParam(name="customerTown", required = false) String customerTown,
            @RequestParam(name="age", required = false) Integer age
    ){
        if (courseName != null && customerTown == null && age == null){
            return new ResponseEntity<>(customerRepository.findByBookingsCourseName(courseName), HttpStatus.OK);
        }
        if (courseName != null && customerTown != null && age == null){
            return new ResponseEntity<>(customerRepository.findByBookingsCourseNameAndCustomerTown(courseName, customerTown), HttpStatus.OK);
        }
        if (age != null && customerTown != null && courseName != null){
            return new ResponseEntity<>(customerRepository.findByAgeGreaterThanAndCustomerTownAndBookingsCourseName(age, customerTown, courseName), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
