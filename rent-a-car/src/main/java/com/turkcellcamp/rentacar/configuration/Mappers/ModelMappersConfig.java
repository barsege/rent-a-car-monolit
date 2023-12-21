package com.turkcellcamp.rentacar.configuration.Mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMappersConfig {
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
