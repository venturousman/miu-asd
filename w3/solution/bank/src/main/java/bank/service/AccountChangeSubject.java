package bank.service;

import java.util.ArrayList;
import java.util.Collection;

import bank.domain.Account;

public class AccountChangeSubject {
    private Collection<IAccountChangeObserver> observerlist = new ArrayList<IAccountChangeObserver>();

	public void addObserver(IAccountChangeObserver observer) {
		observerlist.add(observer);
	}

	public void removeObserver(IAccountChangeObserver observer) {
		observerlist.remove(observer);
	}

	public void onChange(Account account) {
		for (IAccountChangeObserver observer : observerlist) {
			observer.update(account);
		}
	}
}
