package com.slot.service;

import org.bouncycastle.util.Exceptions;
import org.hibernate.procedure.NoSuchParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.discovery.converters.Auto;
import com.slot.dao.SlotDao;
import com.slot.entity.Booking;
import com.slot.entity.Slot;
import com.slot.entity.SlotDTO;
import com.slot.externalService.BookingService;
@Service
public class SlotServImpl implements SlotServ {

    @Autowired
    private SlotDao slotDao;

    @Autowired
   private BookingService bookingService;

    @Override
    public Slot createSlot(Slot slot) {
        return this.slotDao.save(slot);
    }

    @Override
    public void delSlot(int id) {
      this.slotDao.findById(id).orElseThrow(() -> new RuntimeException("No such slots"));
    }

    @Override
    public Booking booking(Booking books,SlotDTO slot) {
      if(slot == null){
        throw new IllegalArgumentException("no such slot");
      }

     Slot slots = this.slotDao.findById(slot.getSlotId()).orElseThrow(() -> new NoSuchParameterException("No such id"));

    slots.setStatus(false);
    slots.setS_Dates("Aile ko date");
    slots.setS_Time("Current time");
    
  Booking savedBooking = bookingService.booking(books);
  slots.setBooksBid(savedBooking.getBId());

  this.slotDao.save(slots);

  


    return books;
    
    }

    



}
