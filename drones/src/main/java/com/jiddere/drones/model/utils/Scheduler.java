package com.jiddere.drones.model.utils;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jiddere.drones.model.Drone;
import com.jiddere.drones.repository.DroneRepository;

/** This is a scheduler class for logging the battery percentage of all drones together
 with the drone serial number at intervals, 
 both the initial and fixedDelay values is in the properties file**/
@Component
public class Scheduler {
	private static final Logger LOGGER = LoggerFactory.getLogger(Scheduler.class);

	private DroneRepository repository;

	@Autowired
	public void setDroneRepository(DroneRepository repository) {
		this.repository = repository;
	}

	@Scheduled(fixedDelayString = "${time.delay}", initialDelayString = "${time.init}")
	public void checkBattery() {
		List<Drone> drones = repository.findAll();
		
		for (Drone drone : drones) {
			LOGGER.info("battery level:: " + drone.getBattery() + "%  for drone with serial:: "
					+ drone.getSerial().toUpperCase());
		}
	}

}
