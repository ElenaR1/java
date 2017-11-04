import java.util.Scanner;
public class PatternMatcher {

	
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
			String s2=p.substring(pos+1);
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
	


	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner a=new Scanner(System.in);
		String s1,s2;
		System.out.println("First string: ");
		s1=a.nextLine();
		System.out.println("Second string: ");
		s2=a.nextLine();	
		
		System.out.println(match(s1, s2));
		
		
		
	}

}
