package com.turkcellcamp.rentacar.business.dto.responses.get;

import com.turkcellcamp.rentacar.entities.States;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCarsResponse {

	private int id;
	private int modelYear;
	private String plate;
	private States state;
	private double dailyPrice;
	
	//private GetAllModelsResponse model;
}
