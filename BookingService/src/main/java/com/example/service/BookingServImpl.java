package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BookingDao;
import com.example.entity.Bookings;

@Service
public class BookingServImpl implements BookingServ {

    @Autowired
    private BookingDao bookingDao;

    @Override
    public Bookings doneBooking(Bookings books) {
        Bookings saveBooking = this.bookingDao.save(books);
        return saveBooking;
    }

    @Override
    public List<Bookings> allBookings() {
        List<Bookings> allBooks = this.bookingDao.findAll();
        return allBooks;
    }

}
