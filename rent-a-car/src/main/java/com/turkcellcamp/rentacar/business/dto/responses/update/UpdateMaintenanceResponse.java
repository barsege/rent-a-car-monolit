package com.turkcellcamp.rentacar.business.dto.responses.update;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMaintenanceResponse {
	private int id;
	private int carId;
	private String information;
	private boolean isCompleted;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
}
