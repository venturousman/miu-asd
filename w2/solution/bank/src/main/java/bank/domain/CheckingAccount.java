package bank.domain;

import bank.service.CheckingInterest;

public class CheckingAccount extends Account {

	public CheckingAccount(long accountnr) {
		super(accountnr);
		this.setInterestStrategy(new CheckingInterest());
	}

}
