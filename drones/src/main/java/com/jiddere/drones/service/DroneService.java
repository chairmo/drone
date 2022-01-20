package com.jiddere.drones.service;

import java.util.List;

import com.jiddere.drones.model.Drone;
import com.jiddere.drones.model.Medication;


public interface DroneService {
	void addDrone(Drone drone);
	void addMedication(long id, Medication medication);
	List<Medication> getDroneMedications(long droneId);
	List<Drone> getAvailableDrones();
//	boolean isDroneAvailable();
	int getDroneBattery(long droneId);
	
}
