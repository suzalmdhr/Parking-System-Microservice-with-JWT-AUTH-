package com.slot.service;

import com.slot.entity.Booking;
import com.slot.entity.Slot;
import com.slot.entity.SlotDTO;

public interface SlotServ {

    Slot createSlot(Slot slot);

    void delSlot(int id);

    Booking booking(Booking books,SlotDTO slot);

}
