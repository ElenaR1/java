package first;
import java.util.Scanner;

public class myclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner a=new Scanner(System.in);//we make a new scanner var
		System.out.println(a.nextLine());
	}

}

Scanner a=new Scanner(System.in);//we make a new scanner var
		double fn, sn, ans;
		System.out.println("fn: ");
		fn=a.nextDouble();
		System.out.println("sn: ");
		sn=a.nextDouble();
		ans=fn+sn;
		System.out.println(ans);

classes
package first;
import java.util.Scanner;

public class myclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		second  obj=new second();
		Scanner input=new Scanner(System.in);
		System.out.println("enter name ");
		String temp=input.nextLine();
		obj.setName(temp);
		System.out.println(obj.getName());
		//obj.msg();
	}
}

package first;

public class second {
	private String girlname;
  public void setName(String name)
  {
	  girlname=name;
  }
  public String getName()
  {
	  return girlname;
  }
  public void msg()
  {
	  System.out.printf("ur gf is %s", getName());
  }
}

1zad

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


public class second {
	public static int getPlateauLength(String a)
	{
		//Scanner input=new Scanner(System.in);
		//System.out.println("enter the string: ");
		// a=input.nextLine();
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
	}

package first;
import java.util.Scanner;

public class myclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("enter the string: ");
		String a=input.nextLine();
		second obj=new second();
		System.out.println(obj.getPlateauLength(a));

}}

Second Task
/* String a="aoblahkl";
		    StringBuilder sb = new StringBuilder(string);
		    
		    System.out.println(pos);
		    
		    sb.deleteCharAt(3);
		    // Prints out "blah"
		    System.out.println(a.contains(sb.toString()));*/


import java.util.Scanner;
public class PatternMatcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner a=new Scanner(System.in);
		String s1,s2;
		System.out.println("First string: ");
		s1=a.nextLine();
		System.out.println("Second string: ");
		s2=a.nextLine();
		
		/*String s1="abcdef";
		String s2="?e";
		String s3="a*";*/
		Pmc obj=new Pmc();
		System.out.println(obj.match(s1, s2));
		
		/*String string = "bla*hor";
		char question='*';
		int pos=string.indexOf(question);
		//System.out.println(pos);
		String s1=string.substring(0, pos);
		int len=s1.length();
		
		System.out.println(s1);
		System.out.print("len: ");
		System.out.println(len);
		
		String s2=string.substring(pos+1);
		System.out.println(s2);
		//System.out.println(string.indexOf(s2));
		System.out.print("difference: ");
		System.out.println(string.indexOf(s2)-len);
		
		String res=s1+s2;
		System.out.println(res);
		*/
		
	}

}


public class Pmc {
    public static boolean match(String s, String p)
    {
        if (p.isEmpty())
        {
        return true;
        }
        if(s.contains(p))
        {
        return true;
        }
        char question='?';
        char star='*';
        String questStr=""+question;
        String starStr=""+star;
       
        if(p.contains(questStr))
        {
            int pos=p.indexOf(question);
            String s1=p.substring(0, pos);
            int len=s1.length();
            System.out.printf("s1=%s",s1);
            System.out.println();
            System.out.println(s.indexOf(s1));
            //System.out.println(len);
            String s2=p.substring(pos+1);
            System.out.printf("s2=%s",s2);
            System.out.println();
            System.out.println(s.indexOf(s2));
            System.out.println(s.indexOf(s1));
            System.out.println(len);
            System.out.println(s.indexOf(s2)-(s.indexOf(s1)+len));
            if(s.contains(s1)&s.contains(s2)&(s.indexOf(s2)-(s.indexOf(s1)+len)==1|s2.isEmpty()|s1.isEmpty()))
            {
                return true;
            }
            else
                return false;
        }
        if(p.contains(starStr))
        {
            int pos=p.indexOf(star);
            String s1=p.substring(0, pos);
            String s2=p.substring(pos+1);
            if(s.contains(s1)&&s.contains(s2))
            {
                return true;
            }
            else
                return false;
           
        }
        return false;
    }
   
}
 

3rd task
 
    public void fillTips(){
        for(int line=1 ; line < 9 ; line++)
            for(int column=1 ; column < 9 ; column++){
                
                    for(int i=-1 ; i<=1 ; i++)
                        for(int j=-1 ; j<=1 ; j++)
                            if(mines[line][column] != -1)
                                if(mines[line+i][column+j] == -1)//if there is a mine in the boxes next to the box in which we are
                                    mines[line][column]++;
                
            }
