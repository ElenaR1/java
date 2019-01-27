
public class ReverseString {
	public ReverseString() {
		
	}
	public void reverses(char s[]) {
		int n=s.length;
		System.out.println(n);
		char newStr[]=new char[n];
		for (int i = 0; i < n; i++) {
			int j=n-i;
			System.out.print("i:"+i+" j:"+j);
			System.out.println();
			if((s[i] >='a' && s[i] <='z') || (s[i] >='A' && s[i] <='Z') )
			{
				System.out.println("s["+i+"] "+s[i]);

				newStr[j-1]=s[i];
				System.out.println("newStr["+(j-1)+"] "+newStr[j-1]);

			}
			else
			{
				System.out.println("s["+i+"] "+s[i]);
				newStr[i]=s[i];
				System.out.println("newStr["+i+"] "+newStr[i]);
			}
		}
		System.out.println(newStr);
		
		
	}
	 public static void reverse(char str[]) 
	    { 
	        // Initialize left and right pointers 
	        int r = str.length - 1, l = 0; 
	  
	        // Traverse string from both ends until 
	        // 'l' and 'r' 
	        while (l < r) 
	        { 
	            // Ignore special characters 
	            if (!Character.isAlphabetic(str[l])) 
	            {
	            	System.out.println("l: " +l);
	                l++; 
	            }
	            else if(!Character.isAlphabetic(str[r])) {
	            	System.out.println("r: " +r);

	                r--; 
	            }
	  
	            // Both str[l] and str[r] are not spacial 
	            else 
	            { 
	                char tmp = str[l]; 
	                str[l] = str[r]; 
	                str[r] = tmp; 
	        		System.out.println(str);

	                l++; 
	                r--; 
	            } 
	        } 
	    } 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Ab,c,de!$";
		char[] charArray = str.toCharArray(); 
		ReverseString obj=new ReverseString();
		obj.reverse(charArray);
		System.out.print("reversed array: ");
		System.out.println(charArray);
		
	}

}
