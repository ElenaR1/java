
public class Course implements Subject {
	private String id;
	private String name;
	private double credit;
	
	public Course()
	{
		this.name="";
		this.id="";
	}
	public Course(String name,String id,int credit)
	{
		setId(id);
		setName(name);
		setCredit(credit);
	}
	
	public void setId(String id)
	{
		this.id=id;
	}
	public String getId()
	{
		return this.id;
	}
	
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	
	public void setCredit(int credit)
	{
		this.credit=credit;
	}
	
	public double getCredit()
	{
		return this.credit;
	}
}
