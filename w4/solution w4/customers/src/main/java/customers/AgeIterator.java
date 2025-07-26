package customers;

import java.util.*;

public class AgeIterator implements Iterator<Customer> {

	private final List<Customer> sortedList;
	private int position;

	public AgeIterator(List<Customer> list) {
		this.position = 0;
		this.sortedList = new ArrayList<>(list);
		Collections.sort(this.sortedList, Comparator.comparingInt(Customer::getAge));
	}

//	public Iterator<Customer> iterator() {
//		return this;
//	}

	@Override
	public boolean hasNext() {
		return this.position < sortedList.size();
	}

	@Override
	public Customer next() {
//		if (this.position < sortedList.size()) {
		if (hasNext()) {
			return sortedList.get(position++);
		}
		return null;
	}
}
