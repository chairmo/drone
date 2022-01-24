package com.jiddere.drones.service;

import java.util.List;

import com.jiddere.drones.model.Drone;
import com.jiddere.drones.model.MedicationDto;


public interface DroneService {
	void addDrone(Drone drone);
	void addMedication(long droneId, MedicationDto medication);
	List<MedicationDto> getDroneMedications(long droneId);
	List<Drone> getAvailableDrones();
	Drone getDrone(long droneId);
	int getDroneBattery(long droneId);
	void checkBattery();
	
}
