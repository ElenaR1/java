//import javafx.util.Pair;
//import java.util.ArrayList;

public class Student implements User {
	private String name;
	private static final int N=50;
	//private Pair <double , Course> [] grades;
	private double[] grades=new double[N];
	private int numOfGrades;
	private double numOfCredits;
	private Course [] courses=new Course[N];
	private int numOfCourses;
	private int facultyNumber;
	
	public Student() 
	{
		this.name="";
		this.facultyNumber=0;
		numOfCredits=0;
		//this("",0);
	}
	
	public Student(String name,int fn)
	{
		setName(name);
		setFacultyNumber(fn);
	}
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	
	
	public void addCourse(Course course)
	{
		if(numOfCourses<N)
		{
		numOfCourses+=1;		
		courses[numOfCourses]=course;	
		}
		else
		{
			System.out.println("No more courses are allowed");
		}
	}
	public void addGrade(Course course,double grade)
	{
		numOfGrades=numOfCourses;
		if(grade>2)
		{
		grades[numOfGrades]=grade;
		numOfCredits+=course.getCredit();	
		}
	}
	
	
	
	public double getCredits()
	{
		return numOfCredits;
	}
	public int getNumOfCourses()
	{
		return numOfCourses;
	}
	
	public boolean canAddCourses()
	{
		if(numOfCourses<N)
		return true;
		else
			return false;
	}
	
	public void setFacultyNumber(int facultyNumber)
	{
		this.facultyNumber=facultyNumber;
	}
	public int getFacultyNumber()
	{
		return this.facultyNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + facultyNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (facultyNumber != other.facultyNumber)
			return false;
		return true;
	}
	
}