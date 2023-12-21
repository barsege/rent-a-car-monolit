package com.turkcellcamp.rentacar.business.abstracts;

import java.util.List;

import com.turkcellcamp.rentacar.business.dto.requests.create.CreateBrandRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdateBrandRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreateBrandResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllBrandResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetBrandResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdateBrandResponse;
import com.turkcellcamp.rentacar.entities.Brand;

public interface BrandService {
	//CRUD operations
	
	List<GetAllBrandResponse> getAll();
	GetBrandResponse getById(int id);
	CreateBrandResponse add(CreateBrandRequest request);
	UpdateBrandResponse update(int id, UpdateBrandRequest brand);
	void delete(int id);
   
}
