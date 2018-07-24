package com.del.dao;
import com.del.exception.PaymentException;
import com.del.util.Message;

public class PaymentDaoImplementation implements PaymentDao {

	private String login = "9843981033";
	private String password = "LiteYaga";
	private double balance = -1000;

	@Override
	public boolean authorize(String login, String password) {

		return this.login.equals(login) && this.password.equals(password);

	}

	@Override
	public double getBalance() {

		return balance;
	}

	@Override
	public void payAmount(Double amount) throws PaymentException {

		if (amount < 0) {
			throw new PaymentException(Message.AMOUNT_NEGATIVE);
		} else {
			balance += amount;
		}

	}

}
