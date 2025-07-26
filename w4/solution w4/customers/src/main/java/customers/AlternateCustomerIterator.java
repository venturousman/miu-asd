package customers;

import java.util.Iterator;
import java.util.List;

public class AlternateCustomerIterator implements Iterator<Customer> {

	private final List<Customer> list;
	private int position;

	public AlternateCustomerIterator(List<Customer> list) {
		this.list = list;
		this.position = 0;
	}

	public Iterator<Customer> iterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		return this.position < list.size();
	}

	@Override
	public Customer next() {
		if (this.position < list.size()) {
			Customer nextElement = list.get(this.position);
			this.position += 2;
			return nextElement;
		}
		return null;
	}

}
