package com.turkcellcamp.rentacar.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.turkcellcamp.rentacar.business.abstracts.CarService;
import com.turkcellcamp.rentacar.business.abstracts.MaintenanceService;
import com.turkcellcamp.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllMaintenanceResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetMaintenanceResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdateMaintenanceResponse;
import com.turkcellcamp.rentacar.entities.Car;
import com.turkcellcamp.rentacar.entities.Maintenance;
import com.turkcellcamp.rentacar.entities.States;
import com.turkcellcamp.rentacar.repository.MaintenanceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MaintenanceServiceImpl implements MaintenanceService {

	private MaintenanceRepository repository;
	private CarService carService;
	private final ModelMapper mapper;

	@Override
	public List<GetAllMaintenanceResponse> getAll() {
		List<Maintenance> maintenances = repository.findAll();
		List<GetAllMaintenanceResponse> responses = maintenances
				.stream()
				.map(maintenance -> mapper.map(maintenances, GetAllMaintenanceResponse.class))
				.toList();
		return responses;
	}

	@Override
	public GetMaintenanceResponse getById(int id) {
		Maintenance maintenance = repository.findById(id).orElseThrow();
		GetMaintenanceResponse response = mapper.map(maintenance, GetMaintenanceResponse.class);
		return response;
	}

	@Override
	public GetMaintenanceResponse returnCarFromMaintenance(int id) {
		checkIfCarExists(id);
		if(!repository.existsByCarIdAndIsCompletedIsFalse(id)) {
			throw new RuntimeException("Bakımda böyle bir araç yok");
		}
		Maintenance maintenance = repository.findByCarIdAndIsCompleteFalse(id);
		maintenance.setCompleted(true);
		maintenance.setEndDate(LocalDateTime.now());
		repository.save(maintenance);
		carService.changeState(id, States.AVAILABLE);
		GetMaintenanceResponse response = mapper.map(maintenance, GetMaintenanceResponse.class);
		return response;
	}
	
	private void checkIfCarExists(int carId) {
		if(!repository.existsById(carId)) {
			throw new RuntimeException("Bakımda böyle bir araç yok");
		}
	}

	@Override
	public CreateMaintenanceResponse add(CreateMaintenanceRequest request) {
		if(!repository.existsByCarIdAndIsCompletedIsFalse(request.getCarId())) {
			throw new RuntimeException("Bakımda böyle bir araç yok");
		}
		Maintenance maintenance = mapper.map(request, Maintenance.class);
		maintenance.setId(0);
		maintenance.setCompleted(false);
		maintenance.setStartDate(LocalDateTime.now());
		maintenance.setEndDate(null);
		
		repository.save(maintenance);
		carService.changeState(request.getCarId(), States.MAINTANENCE);
		CreateMaintenanceResponse response = mapper.map(maintenance, CreateMaintenanceResponse.class);
		return response;
	}

	@Override
	public UpdateMaintenanceResponse update(int id,UpdateMaintenanceRequest request) {
		Maintenance maintenance = mapper.map(request, Maintenance.class);
		maintenance.setId(id);
		repository.save(maintenance);
		UpdateMaintenanceResponse maintenanceResponse = mapper.map(maintenance, UpdateMaintenanceResponse.class);
		return maintenanceResponse;
	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public void changeState(int carId, States state) {
		// TODO Auto-generated method stub
		
	}
	
	

}
