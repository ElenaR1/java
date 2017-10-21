
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Susicockpit obj=new Susicockpit();
		Student Ivan=new Student("Ivan",81123);
		Student Pesho=new Student("Pesho",81103);
		Student Todor=new Student("Todor",81093);
		
		Course Algebra=new Course("Algebra","3124",7);
		Course OOP=new Course("OOP","4235",6);
		Course Java=new Course("Java","5435",5);
		Course MI=new Course("MI","5426",4);
		
		obj.registerStudent(Ivan);
		obj.registerStudent(Pesho);
		obj.registerStudent(Todor);
		//obj.registerStudent(Ivan);
		
		System.out.print("Number of students: ");
		System.out.println(obj.getStudentsCount());
		
		obj.setGrade(Ivan, Algebra, 6);
		obj.setGrade(Ivan,OOP , 4);
		System.out.print("Number of credits of Ivan: ");
		System.out.println(obj.getTotalCredits(Ivan));
		
		
		obj.setGrade(Pesho, Algebra, 6);
		obj.setGrade(Pesho,Java , 5);
		System.out.print("Number of credits of Pesho: ");
		System.out.println(obj.getTotalCredits(Pesho));
	}

}
