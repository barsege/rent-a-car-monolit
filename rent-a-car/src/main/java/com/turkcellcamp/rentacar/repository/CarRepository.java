package com.turkcellcamp.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcellcamp.rentacar.entities.Brand;
import com.turkcellcamp.rentacar.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{
	boolean existsByPlateIgnoreCase(String name);
}
