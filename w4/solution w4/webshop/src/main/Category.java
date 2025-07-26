package main;

import java.util.*;

public class Category implements IProductCatalog {
	private String name;
	private List<IProductCatalog> components = new ArrayList<>();

	public Category(String name) {
		this.name = name;
	}

	public void addComponent(IProductCatalog component) {
		components.add(component);
	}

	public void removeComponent(IProductCatalog component) {
		components.remove(component);
	}

	@Override
	public void print() {
		System.out.println("Category: " + name);
		for (IProductCatalog component : components) {
			component.print();
		}
	}
}
