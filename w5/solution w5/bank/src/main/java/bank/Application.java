package bank;

import java.util.Collection;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountService;
import bank.service.IAccountService;

public class Application {
	public static void main(String[] args) {
		IAccountService accountService = new AccountService();
		HistoryList hlist = new HistoryList();

		// create 2 accounts;
		accountService.createAccount(1263862, "Frank Brown");
		accountService.createAccount(4253892, "John Doe");

		// use account 1;
//		accountService.deposit(1263862, 240);
		DepositCommand depositCmd = new DepositCommand(accountService, 1263862, 240);
		depositCmd.execute();
		hlist.addCommand(depositCmd);

//		accountService.deposit(1263862, 529);
		depositCmd = new DepositCommand(accountService, 1263862, 529);
		depositCmd.execute();
		hlist.addCommand(depositCmd);

//		accountService.withdraw(1263862, 230);
		WithdrawCommand withdrawCmd = new WithdrawCommand(accountService, 1263862, 230);
		withdrawCmd.execute();
		hlist.addCommand(withdrawCmd);

		// use account 2;
//		accountService.deposit(4253892, 12450);
		depositCmd = new DepositCommand(accountService, 4253892, 12450);
		depositCmd.execute();
		hlist.addCommand(depositCmd);

//		accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
		TransferFundsCommand transferFundsCmd = new TransferFundsCommand(accountService, 4253892, 1263862, 100,
				"payment of invoice 10232");
		transferFundsCmd.execute();
		hlist.addCommand(transferFundsCmd);

		// show balances
		Collection<Account> accountlist = accountService.getAllAccounts();
		Customer customer = null;
		for (Account account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println(
					"-Date-------------------------" + "-Description------------------" + "-Amount-------------");
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate().toString(), entry.getDescription(),
						entry.getAmount());
			}
			System.out.println("----------------------------------------" + "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
		}

		hlist.undo();

		// show balances
		System.out.println("----------------------------------------" + "----------------------------------------");
		System.out.println("----------------------------------------" + "----------------------------------------");
		accountlist = accountService.getAllAccounts();
		customer = null;
		for (Account account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println(
					"-Date-------------------------" + "-Description------------------" + "-Amount-------------");
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate().toString(), entry.getDescription(),
						entry.getAmount());
			}
			System.out.println("----------------------------------------" + "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
		}
	}

}
