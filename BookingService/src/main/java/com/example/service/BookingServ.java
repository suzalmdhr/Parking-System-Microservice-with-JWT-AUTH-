package com.example.service;

import java.util.List;

import com.example.entity.Bookings;

public interface BookingServ {


    Bookings doneBooking(Bookings books);

   List<Bookings> allBookings();

}
