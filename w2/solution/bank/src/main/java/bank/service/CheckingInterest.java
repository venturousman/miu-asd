package bank.service;

import bank.domain.*;

public class CheckingInterest implements InterestStrategy {

	@Override
	public double calculateInterest(Account account) {
		if (account == null)
			return 0;
		double balance = account.getBalance();
		if (balance < 1000)
			return balance * 0.015;
		else
			return balance * 0.025;
	}

}
