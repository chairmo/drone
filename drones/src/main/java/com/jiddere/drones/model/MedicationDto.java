package com.jiddere.drones.model;

import lombok.Data;


@Data
public class MedicationDto {
	private long id;

	private String name;
	
	private int weight;
	
//	@Code
	private String code;
	private String imageUrl;
	
	private long droneId;
}
