//import java.util.List;
public class Susicockpit implements Susi {
	private static final int N=1000;
	private Student[] arrayOfStudents=new Student[N];
	private int numOfStudents;
	
	
	public Susicockpit()
	{
		
		numOfStudents=0;
	}
	
	public boolean registerStudent(Student student)
	{
			for(int i=0;i<numOfStudents;i++)
		{
				
			if(arrayOfStudents[i]!=null && student.getFacultyNumber()==arrayOfStudents[i].getFacultyNumber())
			{
				System.out.println("The student is already in the system");
				return false;
			}
		}
		
		if(numOfStudents<N)
		{

		arrayOfStudents[numOfStudents]=student;
		numOfStudents+=1;
		return true;
		}
		else
		{
			System.out.println("No more than 1000 students");
			return false;
		}
	}
	
	public int getStudentsCount()
	{
		return numOfStudents;
	}
	
	public boolean setGrade(Student student, Course course, double grade)
	{
		if(registerStudent(student)==false)
		{
		student.addCourse(course);
		student.addGrade(grade);
		return true;
		}
		else
			return false;
	}
	
	public double getTotalCredits(Student student)
	{
		return student.getCredits();
	}
	
	public double getGPA(Student student)
	{
		return(student.getCredits()/student.getNumOfCourses());
	}
	
}
