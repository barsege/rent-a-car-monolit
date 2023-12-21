package com.turkcellcamp.rentacar.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.turkcellcamp.rentacar.business.abstracts.CarService;
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
import com.turkcellcamp.rentacar.entities.Brand;
import com.turkcellcamp.rentacar.entities.Car;
import com.turkcellcamp.rentacar.entities.Model;
import com.turkcellcamp.rentacar.entities.States;
import com.turkcellcamp.rentacar.repository.CarRepository;
import com.turkcellcamp.rentacar.repository.ModelRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService{

	private final CarRepository repository;
	private final ModelMapper mapper;

	@Override
	public List<GetAllCarsResponse> getAll() {
		List<Car> cars = repository.findAll();
		List<GetAllCarsResponse> response = cars
				.stream()
				.map(car -> mapper.map(car,GetAllCarsResponse.class))
				.toList();
		return response;
	}
	
	@Override
	public List<GetAllCarsResponse> getAllAvailableCars(boolean getAvailable) {
		List<Car> cars = repository.findAll();
		if(getAvailable) {
			List<GetAllCarsResponse> response = cars
					.stream()
					.map(car -> mapper.map(car,GetAllCarsResponse.class))
					.toList();
			return response;
		}
		else {
			List<GetAllCarsResponse> response = cars
                    .stream()
                    .filter(car -> car.getState()!= States.MAINTANENCE)
                    .map(car -> mapper.map(car, GetAllCarsResponse.class))
                    .toList();
            return response;
		}
		
	}

	@Override
	public GetCarResponse getById(int id) {
		checkIfCarExists(id);
		Car car = repository.findById(id).orElseThrow();
		GetCarResponse response = mapper.map(car, GetCarResponse.class);
		return response;
	}

	@Override
	public CreateCarResponse add(CreateCarRequest request) {
		checkIfPlateExists(request.getPlate());
		Car car = mapper.map(request, Car.class);
		car.setId(0);
		car.setState(States.AVAILABLE);
		repository.save(car);
		CreateCarResponse response = mapper.map(car, CreateCarResponse.class);
		
		return response;
	}

	@Override
	public UpdateCarResponse update(int id, UpdateCarRequest request) {
		Car car = mapper.map(request,Car.class);
		car.setId(id);
		repository.save(car);
		UpdateCarResponse response = mapper.map(car, UpdateCarResponse.class);
		return response;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	private void checkIfCarExists(int id) {
		if(!repository.existsById(id)) throw new IllegalArgumentException("Böyle bir marka mevcut değildir");
	}
	
	private void checkIfPlateExists(String name) {
		if(repository.existsByPlateIgnoreCase(name)) {
			throw new RuntimeException("Böyle başka bir kayıt var");
		}
	}

	@Override
	public void changeState(int carId, States state) {
		// TODO Auto-generated method stub
		Car car = repository.findById(carId).orElseThrow();
		car.setState(state);
		repository.save(car);
	}

	

}
