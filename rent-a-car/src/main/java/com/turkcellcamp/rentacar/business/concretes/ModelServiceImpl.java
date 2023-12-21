package com.turkcellcamp.rentacar.business.concretes;

import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.turkcellcamp.rentacar.business.abstracts.ModelService;
import com.turkcellcamp.rentacar.business.dto.requests.create.CreateModelRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdateModelRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreateModelResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllModelsResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetModelResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdateModelResponse;
import com.turkcellcamp.rentacar.entities.Brand;
import com.turkcellcamp.rentacar.entities.Model;
import com.turkcellcamp.rentacar.repository.ModelRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelService{

	private final ModelRepository repository;
	private final ModelMapper mapper;

	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = repository.findAll();
		List<GetAllModelsResponse> response = models
				.stream()
				.map(model -> mapper.map(model,GetAllModelsResponse.class))
				.toList();
		return response;
	}

	@Override
	public GetModelResponse getById(int id) {
		Model model = repository.findById(id).orElseThrow();
		GetModelResponse response = mapper.map(model, GetModelResponse.class);
		return response;
	}

	@Override
	public CreateModelResponse add(CreateModelRequest request) {
		Model model = mapper.map(request, Model.class);
		model.setId(0);
		repository.save(model);
		CreateModelResponse response = mapper.map(model, CreateModelResponse.class);
		
		return response;
	}

	@Override
	public UpdateModelResponse update(int id, UpdateModelRequest request) {
		Model model = mapper.map(request,Model.class);
		model.setId(id);
		repository.save(model);
		UpdateModelResponse response = mapper.map(model, UpdateModelResponse.class);
		return response;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	private void checkOfModelExistsById(int id) {
		if(!repository.existsById(id)) {
			throw new RuntimeException("böyle bir model mevcut değil");
		}
	}
	

}
