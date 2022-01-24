package com.jiddere.drones.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jiddere.drones.model.utils.Code;
import com.jiddere.drones.model.utils.Name;

import lombok.Data;

@Entity
@Data
public class Medication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Name
	private String name;
	
	private int weight;
	
	@Code
	private String code;
	private String imageUrl;
	
	@ManyToOne
	@JoinColumn(name = "droneId")
	private Drone drone;
}
