//import javafx.util.Pair;
import java.util.ArrayList;

public class Student implements User {
	private String name;
	private static final int N=50;
	//private Pair <double , Course> [] grades;
	private double[] grades=new double[N];
	private int numOfGrades=0;
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
	
	
	
	/*public void addCourse(Course course)
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
	}*/
	public void addGrade(Course course,double grade)
	{
		if(numOfCourses<N )
		{
		
		if(grade>2) {
			courses[numOfCourses]=course;
			numOfGrades=numOfCourses;
		grades[numOfGrades]=grade;
		courses[numOfCourses].setGrade(grade);//the grade is for this student && this subject
		numOfCredits+=course.getCredit();	
		numOfCourses+=1;
		numOfGrades=numOfCourses;
		}
		}
		
		else
		{
			System.out.println("No more courses are allowed");
		}
		
	}
	
	public double getGrade(Course course)
	{
		int n;
		for(int i=0;i<courses.length;i++)
		{
			if(course.getName()==courses[i].getName())
				return grades[i];
			break;
		}
		return 0.0;
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
	
	public void printGrades() {
		int size=grades.length;
		for (int i=0;i<size;i++) {
			if(grades[i]!=0.0)
			System.out.println(grades[i]);
		}
	}
	
	public void printCourses() {
		int size=courses.length;
		for (int i=0;i<size;i++) {
			if(courses[i]!=null)
			System.out.println(courses[i].getName());
		}
	}
	public void printCourses2(Course[] c) {
		int size=c.length;
		for (int i=0;i<size;i++) {
			if(c[i]!=null)
			System.out.println(c[i].getName());
		}
	}
	
	public   Course[]   sortCourses()
    {
        Course[] newcourses=new Course[this.numOfCourses];
        Course temp ;
 
        for (int i = 0; i < this.numOfCourses; i++) {
            for (int j = 1; j < (this.numOfCourses - i); j++) {
 
                if (this.courses[j - 1].getGrade() <= this.courses[j].getGrade()) {
                    temp = this.courses[j - 1];
                    this.courses[j - 1]=this.courses[j];
                    this.courses[j]=temp;
                   
                }
 
            }
        }
       
        for (int i = 0; i < this.numOfCourses; i++)
        {
             newcourses[i]=new Course(this.courses[i].getId(),this.courses[i].getName(),this.courses[i].getCredit(),
            		 this.courses[i].getType());
             newcourses[i].setGrade(this.courses[i].getGrade());
               
        }
       
        //this.printCourses2(newcourses);
        return newcourses;
    }
	public Course[] getCourses() {
		return this.courses;
	}
	public double creditsPerType(CourseType type) {
		double sum=0;
		for( int i=0;i<numOfCourses;i++) {
			if(courses[i]!=null && courses[i].getType().equals(type)) {
				System.out.println("lal");
				sum+=courses[i].getCredit();
			}
		}
		return sum;
	}

/*	@Override
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
	}*/
	
}
