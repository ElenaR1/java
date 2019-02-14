import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Vector;
import java.util.Map.Entry;

public class Intervals {
	Vector<Integer> v = new Vector<>();
	public void checkCons(int[] a) {
	      Arrays.sort(a);
	  
		int count=0;
		for (int i = 0; i < a.length; i++) {
			if(i!=a.length-1 && a[i]+1==a[i+1]) {
				count++;
				v.addElement(a[i]);
			}
			if(i>0 && i!=a.length-1 && a[i]+1!=a[i+1] && a[i]==a[i-1]+1) {
				count++;
				v.addElement(a[i]);
				String s="["+v.get(0)+", "+v.get(v.size()-1)+"]"+" with consecutive count of "+count;
				count=0;
				v.clear();
				System.out.println(s);
			}
			if(i>0 && i!=a.length-1 && a[i]+1!=a[i+1] && a[i]!=a[i-1]+1) {
				System.out.println("["+a[i]+", "+a[i]+"] with consecutive count of 1" );
			}
			if(i==0 && a[i]+1!=a[i+1]) {
				System.out.println("["+a[i]+", "+a[i]+"] with consecutive count of 1" );
			}
			if(i==a.length-1 && a[i]!=a[i-1]+1) {
				System.out.println("["+a[i]+", "+a[i]+"] with consecutive count of 1" );
			}
			if(i==a.length-1 && a[i]==a[i-1]+1) {
				count++;
				v.addElement(a[i]);
				String s="["+v.get(0)+", "+v.get(v.size()-1)+"]"+" with consecutive count of "+count;
				count=0;
				v.clear();
				System.out.println(s);
			}
		}
	}
	void print() {
		System.out.println("Hello World!");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr = {1,5,-2,3,2,10,6};

	      // Print all the array elements
	      for (int i = 0; i < arr.length; i++) {
	         System.out.print(arr[i] + " ");
	      }
	      System.out.println();
	      System.out.println("----------------");	  

	      Intervals obj=new Intervals();
	      obj.checkCons(arr);
	      System.out.println("------------");
	      int[] arr2 = {-181,
	    		  -414,
	    		  441,
	    		  889,
	    		  -547,
	    		  -313,
	    		  622,
	    		  679,
	    		  782,
	    		  -640};
	      obj.checkCons(arr2);
	      System.out.println("------------");
	      int[] arr3= {123,
	    		  567,
	    		  124,
	    		  568,
	    		  -100,
	    		  -99};
	      obj.checkCons(arr3);
	      
	     
	      
	}

}
