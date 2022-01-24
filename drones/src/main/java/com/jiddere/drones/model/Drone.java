package com.jiddere.drones.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.jiddere.drones.model.utils.ModelType;
import com.jiddere.drones.model.utils.State;

import lombok.Data;

@Entity
@Data
public class Drone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Size(min = 3, max = 100)
	private String serial;

	@Enumerated(EnumType.STRING)
	private ModelType model;

	private String weight;
	private int battery;

	@Enumerated(EnumType.STRING)
	private State state;

}
