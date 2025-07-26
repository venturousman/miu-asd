package main;

public class Product implements IProductCatalog {

	private String name;
	private double price;

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public void print() {
		System.out.println("Product: " + name + " ($" + price + ")");
	}

}
