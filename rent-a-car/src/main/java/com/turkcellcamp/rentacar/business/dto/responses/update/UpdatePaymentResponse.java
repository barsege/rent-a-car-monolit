package com.turkcellcamp.rentacar.business.dto.responses.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePaymentResponse {

	private int id;
	private String cardNumber;
	private String cardHolder;
	private int cardExpirationMonth;
	private int cardExpirationYear;
	private int cardCvv;
	private double balance;
}
