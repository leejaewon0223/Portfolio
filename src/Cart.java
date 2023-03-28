

import java.util.ArrayList;
import java.util.List;

public class Cart<E> {
	private List<E> items;

	public Cart() {
		this.items = new ArrayList<>();
	}

	public void addItem(E item) {
		this.items.add(item);
	}

	public List<E> getItems() {
		return items;
	}

	public void setItems(List<E> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Cart [items=" + items + "]";
	}

}
