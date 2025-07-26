package bank;

import bank.service.IAccountService;

public class DepositCommand implements ICommand {

	IAccountService accountService;
	long accountNumber;
	double amount;

	public DepositCommand(IAccountService accountService, long accountNumber, double amount) {
		this.accountService = accountService;
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	@Override
	public void execute() {
		this.accountService.deposit(accountNumber, amount);
	}

	@Override
	public void unExecute() {
		this.accountService.withdraw(accountNumber, amount);
	}

}
