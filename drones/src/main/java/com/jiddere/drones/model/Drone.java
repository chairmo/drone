package com.jiddere.drones.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Drone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Size(min = 3, max = 100)
	private String sNumber;

	@Enumerated(EnumType.STRING)
	private ModelType model;

	private String weight;
	private int battery;

	@Enumerated(EnumType.STRING)
	private State state;
	
	@OneToMany(mappedBy = "drone")
	private List<Medication> medications;

}
