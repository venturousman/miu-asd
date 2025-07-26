package bank.service;

import bank.domain.*;

public interface InterestStrategy {
	public double calculateInterest(Account account);
}
