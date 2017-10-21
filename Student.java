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
		numOfCredits+=course.getCredit();		
		}
	}
	public void addGrade(double grade)
	{
		numOfGrades=numOfCourses;
		grades[numOfGrades]=grade;
	}
	
	
	
	public double getCredits()
	{
		return numOfCredits;
	}
	public int getNumOfCourses()
	{
		return numOfCourses;
	}
	
	
	public void setFacultyNumber(int facultyNumber)
	{
		this.facultyNumber=facultyNumber;
	}
	public int getFacultyNumber()
	{
		return this.facultyNumber;
	}
}
