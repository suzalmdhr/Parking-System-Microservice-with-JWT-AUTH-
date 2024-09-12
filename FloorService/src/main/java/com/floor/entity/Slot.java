package com.floor.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Slot {


    private int sId;

    private String slotName;

    private String s_Dates;

    private String s_Time;

    private Boolean status;

    private int booksBid;

   private int floorId;

}
