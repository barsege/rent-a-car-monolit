package com.turkcellcamp.rentacar.api.controllers;

import com.turkcellcamp.rentacar.business.abstracts.BrandService;
import com.turkcellcamp.rentacar.business.dto.requests.create.CreateBrandRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdateBrandRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreateBrandResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllBrandResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetBrandResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdateBrandResponse;
import com.turkcellcamp.rentacar.entities.Brand;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
	private final BrandService service;

	public BrandsController(BrandService service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public List<GetAllBrandResponse> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public GetBrandResponse getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@PostMapping
	public CreateBrandResponse add(@RequestBody CreateBrandRequest request) {
		return service.add(request);
	}
	
	@PutMapping("/{id}")
	public UpdateBrandResponse update(@PathVariable int id, @RequestBody UpdateBrandRequest request) {
		return service.update(id, request);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}
	
	
	
   
}
