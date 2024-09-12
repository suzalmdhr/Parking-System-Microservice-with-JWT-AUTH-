package com.slot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SlotDTO {

    private int slotId;

    private String slotName;

    private String s_Dates;

    private String s_Time;

    private Boolean status;

    private int booksBid;

    private int floorId;

}
