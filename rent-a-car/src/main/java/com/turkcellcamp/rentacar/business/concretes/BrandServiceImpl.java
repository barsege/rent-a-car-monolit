package com.turkcellcamp.rentacar.business.concretes;

import com.turkcellcamp.rentacar.business.abstracts.BrandService;
import com.turkcellcamp.rentacar.business.dto.requests.create.CreateBrandRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdateBrandRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreateBrandResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllBrandResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetBrandResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdateBrandResponse;
import com.turkcellcamp.rentacar.entities.Brand;
import com.turkcellcamp.rentacar.repository.BrandRepository;

import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@AllArgsConstructor
public class BrandServiceImpl implements BrandService {

	private final BrandRepository repository;
	private final ModelMapper mapper;
	
	
	

	public BrandServiceImpl(BrandRepository repository, ModelMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<GetAllBrandResponse> getAll() {
		// TODO Auto-generated method stub
		List<Brand> brands = repository.findAll();
		List<GetAllBrandResponse> response = brands
				.stream()
				.map(brand -> mapper.map(brand, GetAllBrandResponse.class))
				.toList();
		return response;
	}

	@Override
	public GetBrandResponse getById(int id) {
		// TODO Auto-generated method stub
		checkIfBrandExists(id);
		Brand brand = repository.findById(id).orElseThrow();
		GetBrandResponse brandResponse = mapper.map(brand, GetBrandResponse.class);
		return brandResponse;
	}

	@Override
	public CreateBrandResponse add(CreateBrandRequest request) {
		// TODO Auto-generated method stub
		checkNameIfExists(request.getName());
		
		Brand brand = mapper.map(request, Brand.class);
		brand.setId(0);
		repository.save(brand);
		CreateBrandResponse response = mapper.map(brand, CreateBrandResponse.class);
		
		return response;
	}

	@Override
	public UpdateBrandResponse update(int id, UpdateBrandRequest request) {
		// TODO Auto-generated method stub
		checkIfBrandExists(id);
		Brand brand = mapper.map(request, Brand.class);
		brand.setId(id);
		repository.save(brand);
		UpdateBrandResponse response = mapper.map(brand, UpdateBrandResponse.class);
		
		return response;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		checkIfBrandExists(id);
		repository.deleteById(id);
		
	}
	
	//buisness rule
	private void checkIfBrandExists(int id) {
		if(!repository.existsById(id)) throw new IllegalArgumentException("Böyle bir marka mevcut değildir");
	}
	
	private void checkNameIfExists(String name) {
		if(repository.existsByNameIgnoreCase(name)) {
			throw new RuntimeException("Böyle başka bir kayıt var");
		}
	}

    
}
