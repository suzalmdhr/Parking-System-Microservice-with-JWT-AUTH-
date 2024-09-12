package com.slot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slot.entity.Booking;
import com.slot.entity.BookingRequest;
import com.slot.entity.Slot;
import com.slot.entity.SlotDTO;
import com.slot.service.SlotServ;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/slot")
public class SlotController {

    @Autowired
    private SlotServ slotServ;

    @PostMapping
    public ResponseEntity<Slot> createSlot(@RequestBody Slot slot){

Slot slots = this.slotServ.createSlot(slot);
return ResponseEntity.status(HttpStatus.CREATED).body(slots);

    }


    @GetMapping("/{id}")
    public ResponseEntity<Void> delSlot(@PathVariable("id") int id){
this.slotServ.delSlot(id);
return ResponseEntity.noContent().build();
    }


    @GetMapping("path")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    @PostMapping("/books/slots")
    public ResponseEntity<Booking> doBooking(@RequestBody BookingRequest request){
        System.out.println(request.getBooking());
        System.out.println(request.getSlot().getSlotId());
        Booking booking = this.slotServ.booking(request.getBooking(), request.getSlot());
        return ResponseEntity.ok(request.getBooking());

    }

    // @PostMapping("/books/slots")
    // public String doBookings(@RequestBody BookingRequest request){

    //     System.out.println(request.getBooking());
    //     System.out.println(request.getSlot().getSId());
        
    //     System.out.println(request.getSlot().getSlotName());
    //     return "lauda";
    // }

    @PostMapping("/book/slot")
    public String check(@RequestBody SlotDTO slot){
System.out.println(slot.getSlotId());
System.out.println(slot.getSlotName());
return "kauda";
    }

}
