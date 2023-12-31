package com.turkcellcamp.rentacar.business.dto.responses.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentResponse {

	private int id;
	private String cardNumber;
	private String cardHolder;
	private int cardExpirationMonth;
	private int cardExpirationYear;
	private int cardCvv;
	private double balance;
}
