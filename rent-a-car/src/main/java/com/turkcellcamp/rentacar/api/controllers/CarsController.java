package com.turkcellcamp.rentacar.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.turkcellcamp.rentacar.business.abstracts.CarService;
import com.turkcellcamp.rentacar.business.abstracts.ModelService;
import com.turkcellcamp.rentacar.business.dto.requests.create.CreateCarRequest;
import com.turkcellcamp.rentacar.business.dto.requests.create.CreateModelRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdateCarRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdateModelRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreateCarResponse;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreateModelResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllCarsResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllModelsResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetCarResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetModelResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdateCarResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdateModelResponse;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cars")
public class CarsController {
	private final CarService service;
	
	@GetMapping
	public List<GetAllCarsResponse> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public GetCarResponse getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CreateCarResponse add(@RequestBody CreateCarRequest request) {
		return service.add(request);
	}
	
	@PutMapping("/{id}")
	public UpdateCarResponse update(@PathVariable int id, @RequestBody UpdateCarRequest request) {
		return service.update(id, request);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable int id) {
		service.delete(id);
	}
}
