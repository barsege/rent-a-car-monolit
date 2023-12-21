package com.turkcellcamp.rentacar.business.dto.requests.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentRequest {
	private String cardNumber;
	private String cardHolder;
	private int cardExpirationMonth;
	private int cardExpirationYear;
	private int cardCvv;
	private double balance;
}
