package com.del.dao;

import com.del.exception.PaymentException;

public interface PaymentDao {

	boolean authorize(String login, String password);

	double getBalance();

	void payAmount(Double amount) throws PaymentException;

}
