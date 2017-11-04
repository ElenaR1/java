package bg.uni.sofia.fmi.mjt.shopping;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apple a1=new Apple("apple","red",1.3);
		Apple a2=new Apple("apple","red",1.3);
		Apple a3=new Apple("apple","red",1.3);
		Apple a4=new Apple("apple","red",1);
		System.out.println(a1.equal(a2));
		System.out.println(a1.equal(a4));
		
		ListShoppingCart obj=new ListShoppingCart();
		obj.addItem(a1);
		obj.addItem(a2);
		obj.addItem(a3);
		obj.addItem(a4);
		
		System.out.println(obj.getTotal());
		
	/*	try {
			obj.removeItem(a4);
		} catch (ItemNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(obj.getTotal());	*/
		
		System.out.println(obj.getQuantityOfItem(a1));	
		System.out.println(obj.getQuantityOfItem(a3));	
		System.out.println(obj.getQuantityOfItem(a4));	
		
		obj.print();
		
		}

}
