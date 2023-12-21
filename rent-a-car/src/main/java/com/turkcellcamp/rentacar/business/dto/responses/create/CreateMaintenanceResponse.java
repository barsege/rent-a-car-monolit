package com.turkcellcamp.rentacar.business.dto.responses.create;

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
public class CreateMaintenanceResponse {
	private int id;
	private int carId;
	private String information;
	private boolean isCompleted;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
}
