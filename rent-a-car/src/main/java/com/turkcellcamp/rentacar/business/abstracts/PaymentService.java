package com.turkcellcamp.rentacar.business.abstracts;

import java.util.List;

import com.turkcellcamp.rentacar.business.dto.requests.create.CreatePaymentRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdatePaymentRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreatePaymentResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllPaymentResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetPaymentResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdatePaymentResponse;

public interface PaymentService {

	List<GetAllPaymentResponse> getAll();
	GetPaymentResponse getById(int id);
	CreatePaymentResponse add(CreatePaymentRequest request);
	UpdatePaymentResponse update(int id, UpdatePaymentRequest request);
	void delete();
}
