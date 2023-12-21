package com.turkcellcamp.rentacar.api.controllers;

import java.util.List;

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
import com.turkcellcamp.rentacar.business.abstracts.MaintenanceService;
import com.turkcellcamp.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllMaintenanceResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetMaintenanceResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdateMaintenanceResponse;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/maintenance")
public class MaintenanceController {

	private final MaintenanceService service;
	
	@GetMapping
    public List<GetAllMaintenanceResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetMaintenanceResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public CreateMaintenanceResponse add(@RequestBody CreateMaintenanceRequest request) {
        return service.add(request);
    }

    @PutMapping("/return/{carId}")
    public GetMaintenanceResponse returnCarFromMaintenance(@PathVariable int carId) {
        return service.returnCarFromMaintenance(carId);
    }

    @PutMapping("/{id}")
    public UpdateMaintenanceResponse update(@PathVariable int id, @RequestBody UpdateMaintenanceRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")  
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
