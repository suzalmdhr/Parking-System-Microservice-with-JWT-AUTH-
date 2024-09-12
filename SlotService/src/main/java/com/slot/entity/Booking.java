package com.slot.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Booking {

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
