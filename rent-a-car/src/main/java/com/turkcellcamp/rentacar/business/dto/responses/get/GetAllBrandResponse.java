package com.turkcellcamp.rentacar.business.dto.responses.get;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBrandResponse {
	private int id;
	private String name;
	//private List<GetAllModelsResponse> models;
	
}
