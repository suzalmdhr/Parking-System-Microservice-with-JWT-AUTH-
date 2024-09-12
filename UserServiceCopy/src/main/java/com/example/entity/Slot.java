package com.example.entity;

import java.sql.Date;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Slot {

    private int sid;

    private String slotName;

    private Date s_date;

    private LocalTime s_time;

    private Boolean status;

    

}
