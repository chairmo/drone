package com.jiddere.drones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jiddere.drones.model.Medication;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

}
