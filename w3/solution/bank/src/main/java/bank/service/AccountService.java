package bank.service;

import java.util.Collection;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;

public class AccountService extends AccountChangeSubject implements IAccountService {
	private IAccountDAO accountDAO;
	private AccountCreateSubject accountCreateSubject;

	public AccountService() {
		accountDAO = new AccountDAO();
		accountCreateSubject = new AccountCreateSubject();
	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);
		accountCreateSubject.onCreate(account); // notify observers of account creation
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
		this.onChange(account); // notify observers of change
	}

	public Account getAccount(long accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
		this.onChange(account); // notify observers of change
	}

	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
		this.onChange(fromAccount); // notify observers of change
		this.onChange(toAccount); // notify observers of change
	}

	public void addObserver(IAccountCreateObserver observer) {
		accountCreateSubject.addObserver(observer);
	}

	public void removeObserver(IAccountCreateObserver observer) {
		accountCreateSubject.removeObserver(observer);
	}

	public void addObserver(IAccountChangeObserver observer) {
		super.addObserver(observer);
	}

	public void removeObserver(IAccountChangeObserver observer) {
		super.removeObserver(observer);
	}
}
