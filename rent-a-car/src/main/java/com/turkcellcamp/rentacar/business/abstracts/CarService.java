package com.turkcellcamp.rentacar.business.abstracts;

import java.util.List;

import com.turkcellcamp.rentacar.business.dto.requests.create.CreateCarRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdateCarRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreateCarResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllCarsResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetCarResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdateCarResponse;
import com.turkcellcamp.rentacar.entities.Brand;
import com.turkcellcamp.rentacar.entities.Car;
import com.turkcellcamp.rentacar.entities.States;

public interface CarService {
	List<GetAllCarsResponse> getAll();
	List<GetAllCarsResponse> getAllAvailableCars(boolean getAvailable);
	GetCarResponse getById(int id);
	CreateCarResponse add(CreateCarRequest car);
	UpdateCarResponse update(int id, UpdateCarRequest car);
	void changeState(int carId, States state);
	void delete(int id);
}
