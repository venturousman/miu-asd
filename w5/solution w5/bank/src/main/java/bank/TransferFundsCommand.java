package bank;

import bank.service.IAccountService;

public class TransferFundsCommand implements ICommand {

	IAccountService accountService;
	long fromAccountNumber;
	long toAccountNumber;
	double amount;
	String description;

	public TransferFundsCommand(IAccountService accountService, long fromAccountNumber, long toAccountNumber,
			double amount, String description) {
		this.accountService = accountService;
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.amount = amount;
		this.description = description;
	}

	@Override
	public void execute() {
		this.accountService.transferFunds(fromAccountNumber, toAccountNumber, amount, description);
	}

	@Override
	public void unExecute() {
		this.accountService.transferFunds(toAccountNumber, fromAccountNumber, amount, description);
	}

}
