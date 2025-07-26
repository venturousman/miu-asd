package customers;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class FilterIterator<T> implements Iterator<T> {

	private final List<T> list;
	private int position;
	private Predicate<T> predicate;

	public FilterIterator(List<T> list, Predicate<T> predicate) {
		this.list = list;
		this.predicate = predicate;
		this.position = 0;
	}

	public Iterator<T> iterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		int pos = position;
		while (pos < list.size()) {
			T nextElement = list.get(pos);
			if (predicate.test(nextElement)) {
				return true;
			} else {
				pos++;
			}
		}
		return false;
	}

	@Override
	public T next() {
		int pos = position;
		while (pos < list.size()) {
			T nextElement = list.get(pos);
			if (predicate.test(nextElement)) {
				position = pos + 1; // find next element in the list
				return nextElement;
			} else {
				pos++;
			}
		}
		return null;
	}

}
