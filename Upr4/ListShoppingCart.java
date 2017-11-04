package bg.uni.sofia.fmi.mjt.shopping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListShoppingCart implements ShoppingCart {
	private List<ItemPair> items;

	public ListShoppingCart() {
		items=new ArrayList<ItemPair>();
	}
	@Override
	public Collection<Item> getUniqueItems() {
		// TODO Auto-generated method stub
		int n=items.size();
		List<Item> uniqueItems = null;
		for(int i=0;i<n;i++) {					
				if(items.get(i).getQuantity()==1)						
				uniqueItems.add(items.get(i).getItem());		
		}
		return uniqueItems;
	}

	@Override
	public Collection<Item> getSortedItems() {
		// TODO Auto-generated method stub
		int i, j, first;
		ItemPair temp=new ItemPair();
	      int numLength = items.size();
	      for (i= numLength - 1; i > 0; i--)
	     {
	           first = 0;                 // initialize to subscript of first element
	           for (j=1; j<=i; j++)   // locate smallest between positions 1 and i.
	          {
	                 if (getQuantityOfItem(items.get(j).getItem()) < 
	                		 getQuantityOfItem(items.get(first).getItem()) )
	                 first = j;
	          }
	         temp = items.get(first);   // Swap smallest found with element in position i.
	         //items.get(first)=items.get(i);
	        // items.get(i)=temp;
	         //num[first] = num[i];
	        // num[i] = temp;
	     }
	}

	@Override
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		if(item!=null) {
			if(isInTheCart(item)!=-1)
			{
				int i=isInTheCart(item);
				items.get(i).increaseQuantity();
			}
		ItemPair newPair=new ItemPair(item);
		items.add(newPair);
		}
		
	}

	@Override
	public void removeItem(Item item) throws ItemNotFoundException {
		// TODO Auto-generated method stub
		int n=items.size();
		if(isInTheCart(item)!=-1) {
		for (int i=0; i<n;i++) {
			if(items.get(i).getItem().equal(item)) {
				items.remove(i);
				break;
			}
		}
		}
		else
			throw new ItemNotFoundException();
	}

	@Override
	public double getTotal() {
		// TODO Auto-generated method stub
		double sum=0;
		int n=items.size();
		for(int i=0;i<n;i++) {
			sum+=items.get(i).getItem().getPrice();
		}
		return sum;
	}
	public int isInTheCart(Item i) {
		int n=items.size();
		for (int i1=0; i1<n;i1++) {
			if(items.get(i1).getItem().equal(i)) {
				return i1;
				}
			}
		return -1;
	}
	public int getQuantityOfItem(Item i) {
		if(isInTheCart(i)!=-1)
		{
		int i1=isInTheCart(i);
		return items.get(i1).getQuantity();
		}
		else
			return -100;
	}
	
	public void print() {
		int n=items.size();
		for(int i=0;i<n;i++) {
			System.out.println(items.get(i).getItem().getName());
		}
	}
	

}
