
public class potpie  {
	private int day;
	private int month;
	private int year;
	
	public potpie(int m,int d,int y)
	{
		this.month=m;
		this.day=d;
		this.year=y;
		
		System.out.printf("the constructor of this is %s\n ",this);// we have a reference to an obj it needs sth in the string 
		//format and it looks in the method toString
	}
	public String toString()//any time u need a  string representation of an obj
	{
		return String.format("%d/%d/%d", day,month,year);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		potpie pot=new potpie(4, 22, 2000);
	}
