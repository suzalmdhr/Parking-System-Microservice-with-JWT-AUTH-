package com.floor.externalservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.floor.entity.Slot;

@FeignClient(name = "SLOTSERVICE")
public interface SlotService {

    @PostMapping("/slot")
    Slot createSlot(Slot slot);

}
