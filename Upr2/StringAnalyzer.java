import java.util.Scanner;

public class StringAnalyzer {
	
	public static int getPlateauLength(String a)
	{
		int counter =1;
		int max=1;
		for(int index=0;index<a.length()-1;index++)
		{
			if(a.charAt(index)==a.charAt(index+1))
			{
				counter++;
				if(counter>max)
				{
					max=counter;
				}
			}
			else
			{
				counter=1;
			}
		}
		return max;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("enter the string: ");
		String a=input.nextLine();
		StringAnalyzer obj=new StringAnalyzer();
		System.out.println(obj.getPlateauLength(a));

	}

}
