package bank;

import bank.service.IAccountService;

public class WithdrawCommand implements ICommand {

	IAccountService accountService;
	long accountNumber;
	double amount;

	public WithdrawCommand(IAccountService accountService, long accountNumber, double amount) {
		this.accountService = accountService;
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	@Override
	public void execute() {
		this.accountService.withdraw(accountNumber, amount);
	}

	@Override
	public void unExecute() {
		this.accountService.deposit(accountNumber, amount);
	}

}
