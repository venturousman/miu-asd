package bank.domain;

import bank.service.SavingsInterest;

public class SavingAccount extends Account {

	public SavingAccount(long accountnr) {
		super(accountnr);
		this.setInterestStrategy(new SavingsInterest());
	}

}
