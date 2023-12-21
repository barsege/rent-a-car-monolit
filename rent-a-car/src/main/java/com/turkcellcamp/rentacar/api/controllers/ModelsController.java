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

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.turkcellcamp.rentacar.business.abstracts.ModelService;
import com.turkcellcamp.rentacar.business.dto.requests.create.CreateModelRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdateModelRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreateModelResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllModelsResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetModelResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdateModelResponse;
import com.turkcellcamp.rentacar.entities.Model;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/models")
public class ModelsController {
	private final ModelService service;

	@GetMapping
	public List<GetAllModelsResponse> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public GetModelResponse getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CreateModelResponse add(@RequestBody CreateModelRequest request) {
		return service.add(request);
	}
	
	@PutMapping("/{id}")
	public UpdateModelResponse update(@PathVariable int id, @RequestBody UpdateModelRequest request) {
		return service.update(id, request);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		service.delete(id);
	}
	
	
}
