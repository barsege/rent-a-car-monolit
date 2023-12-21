package com.turkcellcamp.rentacar.business.abstracts;

import java.util.List;

import com.turkcellcamp.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllMaintenanceResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetMaintenanceResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdateMaintenanceResponse;
import com.turkcellcamp.rentacar.entities.Car;
import com.turkcellcamp.rentacar.entities.States;

public interface MaintenanceService {
	List<GetAllMaintenanceResponse> getAll();
	GetMaintenanceResponse getById(int id);
	GetMaintenanceResponse returnCarFromMaintenance(int id);
	CreateMaintenanceResponse add(CreateMaintenanceRequest request);
	UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request);
	void changeState(int carId, States state);
	void delete(int id);
}
