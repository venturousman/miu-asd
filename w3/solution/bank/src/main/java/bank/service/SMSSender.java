package bank.service;

import bank.domain.Account;

public class SMSSender implements IAccountChangeObserver {
    private String phoneNumber;

    public SMSSender(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(Account account) {
        send(account);
    }

    public void send(Account account) {
        System.out.println("Sending SMS to " + phoneNumber + " about new account: " + account.getAccountnumber());
    }
}
