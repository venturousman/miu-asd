package bank.service;

import bank.domain.Account;

public interface IAccountChangeObserver {
    public void update(Account account);
}
