package bg.uni.sofia.fmi.mjt.shopping;

public class Apple implements Item {
	private String name;
	private String description;
	private double price;
	
	public Apple() {
		name=null;
		description=null;
		price=0.0;
	}
	public Apple(String n, String desc, double p) {
		setName(n);
		setDescription(desc);
		setPrice(p);
	}
	 public void setName(String n) {
		 this.name=n;
	 }
	 public void setDescription(String d) {
		 this.description=d;
	 }
	 public void setPrice(double p) {
		 this.price=p;
	 }
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}
	
}
