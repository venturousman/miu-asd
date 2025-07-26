package bank.service;

import bank.domain.*;

public class SavingsInterest implements InterestStrategy {

	@Override
	public double calculateInterest(Account account) {
		if (account == null)
			return 0;
		double balance = account.getBalance();
		if (balance < 1000)
			return balance * 0.01;
		else if (balance < 5000)
			return balance * 0.02;
		else
			return balance * 0.04;
	}

}
