package bg.uni.sofia.fmi.mjt.shopping;

import java.util.Collection;

public class MapShoppingCart implements ShoppingCart {

	private Map<Item,Integer> items;//quantity
	@Override
	public Collection<Item> getUniqueItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Item> getSortedItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeItem(Item item) throws ItemNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

}
