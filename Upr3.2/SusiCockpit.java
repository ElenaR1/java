//import java.util.List;
public class SusiCockpit implements Susi {
	private static final int N=1000;
	private static final CourseType ELECTIVE = null;
	private static final CourseType REQUIRED = null;
	private Student[] arrayOfStudents=new Student[N];//otherwise it will give me a mistake
	private int numOfStudents;
	
	
	public SusiCockpit()
	{
		
		numOfStudents=0;
	}
	
	@Override
	public boolean registerStudent(Student student) throws StudentAlreadyRegisteredException, CapacityExceededException
	{
			for(int i=0;i<numOfStudents;i++)
		{
				//student.getFacultyNumber()==arrayOfStudents[i].getFacultyNumber()
			if(arrayOfStudents[i]!=null && student.equals(arrayOfStudents[i]))
			{
				//System.out.println("The student is already in the system");
				throw new StudentAlreadyRegisteredException(student.getName());
				
				
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
			//System.out.println("No more than 1000 students");
			//return false;
			throw new CapacityExceededException();
		}
	}
	
	public boolean isRegistered(Student student)
	{
		for(int i=0;i<numOfStudents;i++)
		{
				
			if(arrayOfStudents[i]!=null && student.getFacultyNumber()==arrayOfStudents[i].getFacultyNumber())
			{
				
				return true;
			}
		}
		return false;
	}
	
	public int getStudentsCount()
	{
		return numOfStudents;
	}
	
	public boolean setGrade(Student student, Course course, double grade) throws StudentNotFoundException,CapacityExceededException
	{
		if(isRegistered(student)==true && student.canAddCourses())//it means that the student is registered
		{
		//student.addCourse(course);
		student.addGrade(course,grade);
		return true;
		}
		else if (isRegistered(student)==false)
			//return false;
			throw new StudentNotFoundException();
		else if(!student.canAddCourses())
		{
			throw new CapacityExceededException();
		}
		return false;
	}
	
	public double getTotalCredits(Student student) throws StudentNotFoundException
	{
		if(isRegistered(student)==true)
		{
		return student.getCredits();
		}
		else 
			//return 0.0;
			throw new StudentNotFoundException();
	}
	
	public double getGPA(Student student) throws StudentNotFoundException
	{
		if(isRegistered(student)==true)
		{
		return(student.getCredits()/student.getNumOfCourses());
		}
		else
			//return 0.0;
			throw new  StudentNotFoundException();
	}
	
	public double getCreditsPerType (Student student, CourseType type) throws StudentNotFoundException{
		int sum=0;
		if(isRegistered(student)==true)
		{
		return student.creditsPerType(type);
		}
		else
			throw new  StudentNotFoundException();
	}



public static void main(String[] args) {
	// TODO Auto-generated method stub
	SusiCockpit obj=new SusiCockpit();
	Student Ivan=new Student("Ivan",81123);
	Student Pesho=new Student("Pesho",81103);
	Student Todor=new Student("Todor",81093);
	
	Course Algebra=new Course("Algebra","3124",7, CourseType.REQUIRED);
	Course OOP=new Course("OOP","4235",6,CourseType.PRACTICE);
	Course Java=new Course("Java","5435",5,CourseType.ELECTIVE);
	Course MI=new Course("MI","5426",4,CourseType.ELECTIVE);
	Course DIS=new 	Course("DIS","42512",9,CourseType.REQUIRED);
	System.out.println(Algebra.getType()==DIS.getType());
	
	Course[] courses= {Algebra,OOP,Java,DIS};
	System.out.println("Number of REQUIRED courses:");
	System.out.println(Algebra.countByType(courses, CourseType.REQUIRED));
	
	try {
		obj.registerStudent(Ivan);
		obj.registerStudent(Pesho);
		obj.registerStudent(Todor);
		obj.registerStudent(Ivan);
	} 
	catch (StudentAlreadyRegisteredException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	System.out.println(e.getMessage());	
	} 
	catch (CapacityExceededException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("too many students");	
	}
	
	
	
	System.out.print("Number of students: ");
	System.out.println(obj.getStudentsCount());
	
	
	
	
	
	try {
		obj.setGrade(Ivan, Algebra, 6);
		obj.setGrade(Ivan,OOP , 4);
		obj.setGrade(Ivan,Java , 5);
		obj.setGrade(Ivan,MI , 2);
		System.out.print("Number of credits of Ivan: ");
		System.out.println(obj.getTotalCredits(Ivan));
		obj.setGrade(Ivan,MI , 3);
		System.out.print("Number of credits of Ivan after getting the MI exam: ");
		System.out.println(obj.getTotalCredits(Ivan));
		
		obj.setGrade(Pesho, Algebra, 5);
		obj.setGrade(Pesho,Java , 5);
		obj.setGrade(Pesho,DIS , 3);
		System.out.print("Number of credits of Pesho: ");
		System.out.println(obj.getTotalCredits(Pesho)); 
		
	} catch (StudentNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (CapacityExceededException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//Ivan.printGrades();
	//Ivan.printCourses();
	//Ivan.sortCourses();
	
	try {
		System.out.println("Pesho's credits in required projects: ");
		System.out.println(obj.getCreditsPerType(Pesho,REQUIRED));
	} catch (StudentNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	System.out.println(obj.isRegistered(Pesho));
	
	
	
	try {
		System.out.print("The GPA  of Pesho: ");
		System.out.println(obj.getGPA(Pesho));
	} catch (StudentNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	Student Gosho=new Student("Gosho",38249);
	Gosho.addGrade(MI, 4);
	System.out.println(obj.isRegistered(Gosho));
	System.out.print("Number of credits of Gosho: ");
	
	try {
		System.out.println(obj.getTotalCredits(Gosho));
	} catch (StudentNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();//shows from where the exception comes from
	}
	System.out.print("The GPA  of Gosho: ");
	try {
		System.out.println(obj.getGPA(Gosho));
	} catch (StudentNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
