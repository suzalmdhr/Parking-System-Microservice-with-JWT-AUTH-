package com.floor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Floor {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int f_id;

    private String address;

    private String name;

    private Long numberOfSlots;
    
    


}
