package com.turkcellcamp.rentacar.business.dto.requests.create;

public class CreateModelRequest {

	private int brandId;
	private String name;
	public CreateModelRequest(int brandId, String name) {
		super();
		this.brandId = brandId;
		this.name = name;
	}
	
	
	public CreateModelRequest() {
		super();
	}


	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
