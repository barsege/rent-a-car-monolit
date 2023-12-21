package com.turkcellcamp.rentacar.business.dto.requests.create;

import com.turkcellcamp.rentacar.entities.States;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarRequest {

	private int modelYear;
	private String plate;
	private States state;
	private double dailyPrice;
}
