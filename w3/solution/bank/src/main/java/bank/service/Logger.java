package bank.service;

import bank.domain.Account;

public class Logger implements IAccountChangeObserver {
    @Override
    public void update(Account account) {
        log(account);
    }

    public void log(Account account) {
        System.out.println("Logging account change: " + account.getAccountnumber());
    }
    
}
