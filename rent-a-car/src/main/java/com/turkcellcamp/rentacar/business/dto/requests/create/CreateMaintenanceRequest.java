package com.turkcellcamp.rentacar.business.dto.requests.create;

import java.time.LocalDateTime;

import com.turkcellcamp.rentacar.entities.States;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateMaintenanceRequest {
	private int carId;
	private String information;
}


