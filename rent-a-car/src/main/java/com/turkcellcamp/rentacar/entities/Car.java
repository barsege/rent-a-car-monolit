package com.turkcellcamp.rentacar.entities;

import java.util.List;

import ch.qos.logback.core.subst.Token.Type;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int modelYear;
	private String plate;
	@Enumerated(EnumType.STRING)
	private States state;
	private double dailyPrice;
	
	@ManyToOne
	@JoinColumn(name = "model_id")
	private Model model;
	
	@OneToMany(mappedBy = "car")
	private List<Maintenance> maintenance;
	
	@OneToMany(mappedBy = "car")
    private List<Rental> rentals;
	

}
