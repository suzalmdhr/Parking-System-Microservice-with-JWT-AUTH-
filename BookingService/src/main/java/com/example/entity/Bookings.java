package com.example.entity;

import java.time.LocalDateTime;

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
public class Bookings {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bId;

   private String licNum;
	
	// private String sDate;
	
	// private String eDate;

	private String startDate;

	private String endDate;
	
	private String username;
	
	private String email;
	
	private Boolean status;

    private int userId;
	
	

}
