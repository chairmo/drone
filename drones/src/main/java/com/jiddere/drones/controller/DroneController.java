package com.jiddere.drones.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiddere.drones.model.Drone;
import com.jiddere.drones.model.MedicationDto;
import com.jiddere.drones.service.DroneService;


@RestController
@RequestMapping(value = "/drone", produces = "application/json")
public class DroneController {

	private final DroneService droneService;
	
	
	public DroneController(DroneService service) {
		this.droneService = service;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Drone> getDrone(@PathVariable("id") long id){
		Drone sDrone = droneService.getDrone(id);
		return new ResponseEntity<>(sDrone, HttpStatus.OK);
	}
	
	@GetMapping("/available")
	public ResponseEntity<List<Drone>> getAvailableDrones(){
		List<Drone> drones = droneService.getAvailableDrones();
		if (drones.isEmpty()) {
			return new ResponseEntity<List<Drone>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Drone>>(drones, HttpStatus.OK);
	}
	
	@GetMapping("/battery/{id}")
	public ResponseEntity<Integer> getDroneBattery(@PathVariable("id") long id ){
		return new ResponseEntity<>(droneService.getDroneBattery(id), HttpStatus.OK);
	}
	
	@PostMapping("/new")
	public ResponseEntity<?> addDrone(@RequestBody @Valid Drone drone){
		this.droneService.addDrone(drone);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}/medication")
	public ResponseEntity<List<MedicationDto>> getDroneMedications(@PathVariable("id") long id){
		return new ResponseEntity<List<MedicationDto>>(droneService.getDroneMedications(id), HttpStatus.OK);
	}
	
	@PostMapping("/{id}/medication/new")
	public ResponseEntity<?> addMedication(@PathVariable("id") long id, 
			@RequestBody @Valid MedicationDto medication){
		this.droneService.addMedication(id, medication);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
