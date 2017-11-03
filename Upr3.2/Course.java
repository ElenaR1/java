
public class Course implements Subject {
	private String id;
	private String name;
	private double credit;
	private CourseType type;
	private double grade;
	
	
	public Course()
	{
		this.name="";
		this.id="";
	}
	public Course(String name,String id,double credit,CourseType type)
	{
		setId(id);
		setName(name);
		setCredits(credit);
		this.type=type;
		
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
	
	
	public void setCredits(double credit)
	{
		this.credit=credit;
	}
	
	public double getCredit()
	{
		return this.credit;
	}
	
	
	public CourseType getType() {
		// TODO Auto-generated method stub
		return this.type;
	}
	
	public static int countByType(Course [] courses, CourseType type)
	{
		int n =courses.length;
		int count=0;
		for(int i=0;i<n;i++)
		{
			if(courses[i].getType()==type)
			{
				count++;
			}
		}
		return count;
	}

	
	public void setGrade(double grade)

	{
	this.grade=grade;	
	}

	public double getGrade()

	{
	return this.grade;	
	}
}