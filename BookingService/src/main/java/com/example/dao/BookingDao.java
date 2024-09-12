package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Bookings;

public interface BookingDao extends JpaRepository<Bookings,Integer> {

}
