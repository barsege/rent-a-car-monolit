package com.turkcellcamp.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcellcamp.rentacar.entities.Car;
import com.turkcellcamp.rentacar.entities.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer>{
	Maintenance findByCarIdAndIsCompleteFalse(int carId);
	boolean existsByCarIdAndIsCompletedIsFalse(int carId);
}
