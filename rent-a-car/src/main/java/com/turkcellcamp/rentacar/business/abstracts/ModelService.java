package com.turkcellcamp.rentacar.business.abstracts;

import java.util.List;

import com.turkcellcamp.rentacar.business.dto.requests.create.CreateModelRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdateModelRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreateModelResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllModelsResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetModelResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdateModelResponse;
import com.turkcellcamp.rentacar.entities.Brand;
import com.turkcellcamp.rentacar.entities.Model;

public interface ModelService {
	List<GetAllModelsResponse> getAll();
	GetModelResponse getById(int id);
	CreateModelResponse add(CreateModelRequest request);
	UpdateModelResponse update(int id, UpdateModelRequest model);
	void delete(int id);
}
