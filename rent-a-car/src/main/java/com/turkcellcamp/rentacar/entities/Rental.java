package com.turkcellcamp.rentacar.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rentals")
public class Rental {
	
	private int id;
	private double dailyPrice;
	private int rentedForDays;
	private double totalPrice;
	private LocalDateTime startDate;
	
	@ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
	
	
}
