package bg.uni.sofia.fmi.mjt.shopping;

public interface Item {
	String getName();
    String getDescription();
    double getPrice();
    
    default boolean equal(Item i) {
    	if(i==null)
    		return false;
    	else {
    		if(getName().equals(i.getName()) && getDescription().equals(i.getDescription()) &&
    				getPrice()==i.getPrice())
    			return true;
    		else
    			return false;
    	}
    }
}
