package com.del.service;

import com.del.dao.PaymentDao;
import com.del.dao.PaymentDaoImplementation;
import com.del.exception.PaymentException;
import com.del.service.PaymentService;

public class PaymentServiceImplementation implements PaymentService {

	private PaymentDao pDao;

	public PaymentServiceImplementation() {

		pDao = new PaymentDaoImplementation();

	}

	@Override
	public boolean authenticate(String login, String password) {

		return pDao.authorize(login, password);
	}

	@Override
	public double getBalance() {

		return pDao.getBalance();
	}

	@Override
	public void payAmount(double amount) throws PaymentException {

		pDao.payAmount(amount);

	}

}
