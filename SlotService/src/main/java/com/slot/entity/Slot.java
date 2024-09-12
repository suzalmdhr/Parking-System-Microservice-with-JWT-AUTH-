package com.slot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Slot {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sId;

    private String slotName;

    private String s_Dates;

    private String s_Time;

    private Boolean status;

    private int booksBid;

    private int floorId;




}
