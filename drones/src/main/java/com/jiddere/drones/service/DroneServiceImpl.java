package com.jiddere.drones.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import com.jiddere.drones.model.Drone;
import com.jiddere.drones.model.Medication;
import com.jiddere.drones.model.State;
import com.jiddere.drones.repository.DroneRepository;
import com.jiddere.drones.repository.MedicationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DroneServiceImpl implements DroneService {
	private final DroneRepository droneRepository;
	private final MedicationRepository medicationRepository;

	@Override
	public List<Medication> getDroneMedications(long dronId) {
		Optional<Drone> droneOptional = droneRepository.findById(dronId);
		if (!droneOptional.isPresent()) {
			throw new ObjectNotFoundException("Object not found", " id");
		}
		return droneOptional.get().getMedications();
	}

	@Override
	public List<Drone> getAvailableDrones() {
		List<Drone> drones = droneRepository.findAll();

		List<Drone> drones2 = new ArrayList<>();
		for (Drone drone : drones) {
			if (drone.getBattery() >= 25 && 
					(drone.getState() == State.IDLE || drone.getState() == State.LOADING)) {
				drones2.add(drone);
			}
		}
		return drones2;
	}


	@Override
	public int getDroneBattery(long id) {

		Optional<Drone> droneOptional = droneRepository.findById(id);
		if (!droneOptional.isPresent()) {
			throw new ObjectNotFoundException("Object not found", " id");
		}
		return droneOptional.get().getBattery();
	}
	
	
	@Override
	public void addDrone(Drone drone) {

		
	}

	@Override
	public void addMedication(long id, Medication medication) {

	}

}
