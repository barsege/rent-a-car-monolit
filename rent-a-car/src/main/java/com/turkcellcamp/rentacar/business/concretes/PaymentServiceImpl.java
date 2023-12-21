package com.turkcellcamp.rentacar.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.turkcellcamp.rentacar.business.abstracts.PaymentService;
import com.turkcellcamp.rentacar.business.dto.requests.create.CreatePaymentRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdatePaymentRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreatePaymentResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllPaymentResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetPaymentResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdatePaymentResponse;
import com.turkcellcamp.rentacar.repository.PaymentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService{

	private final PaymentRepository repository;
	private final ModelMapper mapper;
	
	@Override
	public List<GetAllPaymentResponse> getAll() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public GetPaymentResponse getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreatePaymentResponse add(CreatePaymentRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdatePaymentResponse update(int id, UpdatePaymentRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
