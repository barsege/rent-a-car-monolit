package com.turkcellcamp.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcellcamp.rentacar.entities.Rental;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
}
