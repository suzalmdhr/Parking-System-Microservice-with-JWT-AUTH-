package com.slot.externalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.slot.entity.Booking;

@FeignClient(name = "BOOKINGSERVICE")
public interface BookingService {


    @PostMapping("/books")
    Booking booking(Booking booking);



}
