package bg.uni.sofia.fmi.mjt.shopping;

public class ItemPair {
	
	private Item item;
	private  int quantity=1;
	
	public ItemPair() {
		item=null;
	}
	
	public ItemPair(Item i){
		setItem(i);
		//increaseQuantity();
	}
	public void setItem(Item i )
	{
		this.item=i;
	}
	public Item getItem() {
		return this.item;
	}
	
	/*public void setQuantity(int q )
	{
		this.quantity=q;
	}*/
	public int getQuantity() {
		return this.quantity;
	}
	
	public void increaseQuantity() {
		quantity+=1;
	}
	public void decreaseQuantity() {
		quantity-=1;
	}
	
	
	
}
