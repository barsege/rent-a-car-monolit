package com.turkcellcamp.rentacar.business.dto.responses.update;

import com.turkcellcamp.rentacar.entities.States;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarResponse {

	private int id;
	private int modelYear;
	private String plate;
	private States state;
	private double dailyPrice;
}
