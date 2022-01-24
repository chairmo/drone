package com.jiddere.drones.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.jiddere.drones.controller.errors.DroneExceptionError;
import com.jiddere.drones.model.Drone;
import com.jiddere.drones.model.Medication;
import com.jiddere.drones.model.MedicationDto;
import com.jiddere.drones.model.utils.State;
import com.jiddere.drones.repository.DroneRepository;
import com.jiddere.drones.repository.MedicationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DroneServiceImpl implements DroneService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DroneService.class);

	private final DroneRepository droneRepository;
	private final MedicationRepository medicationRepository;

	@Override
	public List<MedicationDto> getDroneMedications(long dronId) {

		List<Medication> medications = medicationRepository.findAll();
		List<MedicationDto> med = new ArrayList<>();
		for (Medication medication : medications) {
			if (medication.getDrone().getId() == dronId) {
				MedicationDto medication2 = new MedicationDto();
				medication2.setCode(medication.getCode());
				medication2.setId(medication.getId());
				medication2.setImageUrl(medication.getImageUrl());
				medication2.setName(medication.getName());
				medication2.setWeight(medication.getWeight());
				medication2.setDroneId(medication.getDrone().getId());
				med.add(medication2);
			}
		}
		return med;
	}

	@Override
	public List<Drone> getAvailableDrones() {
		List<Drone> drones = droneRepository.findAll();

		List<Drone> drones2 = new ArrayList<>();
		for (Drone drone : drones) {
			if (drone.getBattery() >= 25 && (drone.getState() == State.IDLE || drone.getState() == State.LOADING)) {
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
		Drone drone2 = new Drone();
		drone2.setWeight(drone.getWeight());
		drone2.setSerial(drone.getSerial());
		drone2.setModel(drone.getModel());
		drone2.setState(drone.getState());
		drone2.setBattery(drone.getBattery());
//		drone2.setMedications(drone.getMedications());

		droneRepository.save(drone2);
	}

	@Override
	public void addMedication(long droneId, MedicationDto medication) {
		Medication med = new Medication();
		List<Drone> drones = getAvailableDrones();

		if (drones.isEmpty() || medication.getWeight() >= 500) {
			throw new DroneExceptionError("No drone available or medication weight is greater than 500 gram");
		}
		for (Drone drone : drones) {
			if (drone.getId() == droneId) {
				med.setCode(medication.getCode());
				med.setImageUrl(medication.getImageUrl());
				med.setName(medication.getName());
				med.setWeight(medication.getWeight());
				med.setDrone(drone);
//				drone.getMedications().add(med);
			}
		}

		medicationRepository.save(med);

	}

//	@Scheduled(fixedDelay = 6000)
//	public void getBatteryInfo() {
//		List<Drone> drones = droneRepository.findAll();
//		
//		for (Drone drone : drones) {
////			drone.getBattery();
//			LOGGER.info("battery level: ", drone.getBattery() +
//					"%  for drone with serial No.: ", drone.getSerial());
//			System.out.printf("battery level: ", drone.getBattery() +
//					"%  for drone with serial No.: ", drone.getSerial());
//		}
//	}

	@Override
	public Drone getDrone(long droneId) {
		Optional<Drone> dOptional = droneRepository.findById(droneId);
		if (!dOptional.isPresent()) {
			throw new DroneExceptionError("Drone not found");
		}
		return dOptional.get();
	}

	@Override
	@Scheduled(fixedDelay = 6000)
	public void checkBattery() {
		List<Drone> drones = droneRepository.findAll();

		for (Drone drone : drones) {
			LOGGER.info("battery level: ", drone.getBattery() + "%  for drone with serial No.: ", drone.getSerial());
			System.out.printf("battery level: ", drone.getBattery() + "%  for drone with serial No.: ",
					drone.getSerial());
		}
	}

}
