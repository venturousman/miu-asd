package bank.service;

import java.util.ArrayList;
import java.util.Collection;

import bank.domain.Account;

public class AccountCreateSubject {
    private Collection<IAccountCreateObserver> observerlist = new ArrayList<IAccountCreateObserver>();

	public void addObserver(IAccountCreateObserver observer) {
		observerlist.add(observer);
	}

	public void removeObserver(IAccountCreateObserver observer) {
		observerlist.remove(observer);
	}

	public void onCreate(Account account) {
		for (IAccountCreateObserver observer : observerlist) {
			observer.create(account);
		}
	}
}
