package com.turkcellcamp.rentacar.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetPaymentResponse {

	private int id;
	private String cardNumber;
	private String cardHolder;
	private int cardExpirationMonth;
	private int cardExpirationYear;
	private int cardCvv;
	private double balance;
}
