package com.turkcellcamp.rentacar.business.dto.requests.update;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMaintenanceRequest {
	private int carId;
	private String information;
	private boolean isCompleted;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
}

