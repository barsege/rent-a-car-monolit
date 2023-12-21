package com.turkcellcamp.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcellcamp.rentacar.entities.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
	boolean existsByNameIgnoreCase(String name);
}
