package com.turkcellcamp.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcellcamp.rentacar.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	
	Payment findByCardNumber(String cardNumber);
	boolean existsByCardNumber(String cardNumber);
}
