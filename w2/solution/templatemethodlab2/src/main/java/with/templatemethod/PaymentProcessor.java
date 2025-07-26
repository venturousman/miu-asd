package with.templatemethod;

public abstract class PaymentProcessor {
	protected void processPayment(double amount, String currency, Customer customer) {
		double dollarAmount = amount;

		if (currency.contentEquals("EUR")) { // European Euro
			dollarAmount = amount * 1.1;
			System.out.println("Convert " + amount + " " + currency + " to US dollars");
		}
		if (currency.contentEquals("INR")) { // Indian Rupee
			dollarAmount = amount * 0.014;
			System.out.println("Convert " + amount + " " + currency + " to US dollars");
		}

		boolean validation = validatePayment();
		if (validation) {
			executePayment(dollarAmount, currency, customer);
		}
	}

	protected abstract boolean validatePayment();

	protected abstract void executePayment(double amount, String currency, Customer customer);
}
