public Collection<Item> getSortedItems() {
		// TODO Auto-generated method stub
		int i, j, first;
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
	         //temp = items.get(first);   // Swap smallest found with element in position i.
	         //items.get(first)=items.get(i);
	         ItemPair itemI = items.get(i);
	         ItemPair firstitem = items.get(first);
	         ItemPair temp = itemI;
	         itemI = firstitem;
	         firstitem = temp;
	         
	        // items.get(i)=temp;
	         //num[first] = num[i];
	        // num[i] = temp;
	     }
	     
	}
