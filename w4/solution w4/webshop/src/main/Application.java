package main;

public class Application {

	public static void main(String[] args) {
		// Create products
		Product laptop = new Product("Laptop", 999.99);
		Product phone = new Product("Smartphone", 599.99);
		Product tablet = new Product("Tablet", 299.99);
		Product headphones = new Product("Headphones", 99.99);

		// Create categories
		Category electronics = new Category("Electronics");
		Category computers = new Category("Computers");
		Category audio = new Category("Audio");

		// Build hierarchy
		computers.addComponent(laptop);
		computers.addComponent(tablet);
		electronics.addComponent(computers);
		audio.addComponent(headphones);
		electronics.addComponent(phone);
		electronics.addComponent(audio);

		// Print catalog
		System.out.println("=== Product Catalog ===");
		electronics.print();
	}

}
