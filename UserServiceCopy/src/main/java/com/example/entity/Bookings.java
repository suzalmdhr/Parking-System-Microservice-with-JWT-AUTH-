package com.example.entity;

import java.util.Date;


import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bookings {


    private int bid;

    private String licnum;

    private Date sDate;

    private Boolean status;

   
    
}
