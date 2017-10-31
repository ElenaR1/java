
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


