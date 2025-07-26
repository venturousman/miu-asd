package with.templatemethod;

public class PayPalPaymentProcessor extends PaymentProcessor {
	private String paypalAddress;

	public PayPalPaymentProcessor(String paypalAddress) {
		this.paypalAddress = paypalAddress;
	}

	@Override
	protected boolean validatePayment() {
		// logic to validate paypal address
		System.out.println("Validate paypal address " + paypalAddress);
		return true;
	}

	@Override
	protected void executePayment(double amount, String currency, Customer customer) {
		// logic to perform paypal payment
		System.out.println("Perform payment with paypal address " + paypalAddress + " and amount $" + amount);

		// logic to notify customer
		System.out.println("Notify customer " + customer.getName() + " with email " + customer.getEmail()
				+ " about paypal payment to address " + paypalAddress);
	}

}
