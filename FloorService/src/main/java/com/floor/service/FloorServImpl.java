package com.floor.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floor.dao.FloorRepo;
import com.floor.entity.Floor;
import com.floor.entity.Slot;
import com.floor.externalservices.SlotService;


@Service
public class FloorServImpl implements FloorServ {

    @Autowired
    private SlotService slotService;

    @Autowired
    private FloorRepo floorRepo;

    @Override
    public Floor createFloor(Floor floor) {

        Floor savedFloor = this.floorRepo.save(floor);
         Long numberOfSlots = floor.getNumberOfSlots();
          for(int i=1; i <= numberOfSlots; i++){
             Slot slot =new Slot();
            slot.setFloorId(savedFloor.getF_id());
             slot.setSlotName("Slot " + i);
             slot.setStatus(true);

 this.slotService.createSlot(slot);
         }

System.out.println("Now id will geenrate which is " + savedFloor.getF_id());
         return savedFloor;
    }

    @Override
    public void DelFloor(int id) {

        Floor floor = this.floorRepo.findById(id).orElseThrow(() -> new NoSuchElementException("No such floor"));

        this.floorRepo.delete(floor);

        
       
    }

}
