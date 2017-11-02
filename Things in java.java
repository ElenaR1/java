
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
	public String toString()//the toString method is a string representation of an obj
	{
		return String.format("%d/%d/%d", day,month,year);
	}
}



public class Tuna  {
	private String name;
	private potpie birthday;//a reference to a poptpie obj
	
	public Tuna(String theName, potpie theDate)
	{
		name=theName;
		birthday=theDate;
	}
	
	public String toString()//the toString method is a string representation of an obj
	{
		return String.format("My name is %s, my birthday is %s", name,birthday);
		//here for the birtday it goes to the toString method in potpie
	}
	
}


public class Apples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		potpie pot=new potpie(4, 22, 2000);
		System.out.println(pot);
		Tuna tunaObj=new Tuna("Greg",pot);
		System.out.println(tunaObj);
	}

}




//ENUM

public enum testEnum {
	bucky("nice","22"),
	kelsey("cutie","10"),
	julia("bigmistake","12");
	
	private final String description;
	private final String age;
	
	//enumeration constructor
	testEnum(String desc,String ag){
		description=desc;//for bucky for the description we pass nice
		age=ag;//and for the age we pass ag
	}
	public String getDesc(){
		return description;
	}
	public String getAge(){
		return age;
	}
}


public class Apples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testEnum.values()- a built in array of the contants in testEnum-{bucky,kelsey,julia}
		for(testEnum people:testEnum.values()) {//people=i;
			System.out.printf("%s \t %s \t%s \n",people,people.getDesc(),people.getAge());
		}
		}

}



//STATIC

public class Tuna  {
	private String first;
	private String last;
	private static int numOfmembers=0;//every object shares the same variable. When this one changes, it changes all objects
	public Tuna (String fn,String ln) {
		first=fn;
		last=ln;
		numOfmembers++;
		System.out.printf("Constructor for %s %s, members in the club: %d \n",first, last, numOfmembers);
		
	}
	public static int getNumOfMembers()
	{
		return numOfmembers;
	}
	
}


public class Apples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testEnum.values()- a built in array of the contants in testEnum-{bucky,kelsey,julia}
	Tuna mem1=new Tuna("Natalie", "Portman");//natalie has her own first and last name
	Tuna mem2=new Tuna("Julia", "Roberts");//but they all share the number of members in the club
	Tuna mem3=new Tuna("Taylor", "Swift");
		
	System.out.println(mem2.getNumOfMembers());//3 IT'S ALWAYS THE SAME CAUSE THE STATIC VAR IS SAHRED 
	//AMONG ALL OBJECTS from the class
	System.out.println(mem1.getNumOfMembers());//3
	System.out.println(Tuna.getNumOfMembers());//3 when i have static variables i don't need to put an pbject
	//when i'm calling the method i can use the class name
	}

}


//FINAL

public class Tuna  {
	private int sum;
	private final int NUM;//final means that you can't modify the variable no matter what.
	//we can only set it equals to sth once. I should set it equal to sth here or in the constructor
	
	public Tuna(int x) {
		NUM=x;
	}
	
	public void add() {
		sum +=NUM;//sum can change
	}
	public String toString() {
		return String.format("sum = %d \n", sum);
	}
}

public class Apples {

	public static void main(String[] args) {
		Tuna obj=new Tuna(10);
		for(int i=0; i<5; i++)
		{
			obj.add();
			System.out.printf("%s",obj);//10,30,30,30,50
		}

}}

