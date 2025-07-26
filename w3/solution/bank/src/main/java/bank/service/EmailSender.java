package bank.service;

import bank.domain.Account;

public class EmailSender implements IAccountCreateObserver {
    private String emailAddress;

    public EmailSender(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void create(Account account) {
        send(account);
    }

    private void send(Account account) {
        System.out.println("Sending email to " + emailAddress + " about new account: " + account.getAccountnumber());
    }
}
