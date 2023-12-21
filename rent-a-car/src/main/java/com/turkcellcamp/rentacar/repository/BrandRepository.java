package com.turkcellcamp.rentacar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcellcamp.rentacar.entities.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{
	// Custom queries
	boolean existsByNameIgnoreCase(String name);
}
