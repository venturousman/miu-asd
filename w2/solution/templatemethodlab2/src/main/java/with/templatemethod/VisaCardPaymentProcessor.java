package with.templatemethod;

public class VisaCardPaymentProcessor extends PaymentProcessor {
	private VisaCard visaCard;

	public VisaCardPaymentProcessor(VisaCard visaCard) {
		this.visaCard = visaCard;
	}

	@Override
	protected boolean validatePayment() {
		// logic to validate visa card
		System.out.println("Validate visa card with card number " + visaCard.getCreditCardNumber());
		return true;
	}

	@Override
	protected void executePayment(double amount, String currency, Customer customer) {
		// logic to perform payment visa card
		System.out.println("Perform payment with visa card with card number " + visaCard.getCreditCardNumber()
				+ " and amount $" + amount);

		// logic to notify customer
		System.out.println("Notify customer " + customer.getName() + " with email " + customer.getEmail()
				+ " about visa credit card payment with card number " + visaCard.getCreditCardNumber());
	}
}