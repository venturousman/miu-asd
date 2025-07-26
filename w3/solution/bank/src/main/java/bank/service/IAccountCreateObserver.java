package bank.service;

import bank.domain.Account;

public interface IAccountCreateObserver {
	public void create(Account account);
}
