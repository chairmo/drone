package com.jiddere.drones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jiddere.drones.model.Drone;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {

//	List<Drone> findAllByState(State state);
}
