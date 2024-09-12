package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Bookings;
import com.example.service.BookingServ;

@RestController
@RequestMapping("/books")
public class BookingController {

    @Autowired
    private BookingServ bookingServ;

    @PostMapping
    public ResponseEntity<Bookings> createBooks(@RequestBody Bookings bookings){


        
        System.out.println("Booked date is "+ bookings.getLicNum());
        Bookings doneBooking = this.bookingServ.doneBooking(bookings);

        return ResponseEntity.ok(doneBooking);
    }

    @GetMapping
    public ResponseEntity<List<Bookings>> allBooks(){

        List<Bookings> allBookings = this.bookingServ.allBookings();

        return ResponseEntity.ok(allBookings);
    }



}


