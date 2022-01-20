package com.jiddere.drones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jiddere.drones.model.Drone;
import com.jiddere.drones.model.State;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {

	List<Drone> findAllByState(State state);
}
