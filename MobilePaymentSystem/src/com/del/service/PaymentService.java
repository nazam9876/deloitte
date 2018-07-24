package com.del.service;

import com.del.exception.PaymentException;

public interface PaymentService {

	boolean authenticate(String login, String password);

	double getBalance();

	void payAmount(double amount) throws PaymentException;

}
