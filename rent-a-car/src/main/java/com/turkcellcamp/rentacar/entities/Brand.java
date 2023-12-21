package com.turkcellcamp.rentacar.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "brands")
public class Brand {
	
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    
    @OneToMany(mappedBy = "brand")
    private List<Model> models;
    
   
}
