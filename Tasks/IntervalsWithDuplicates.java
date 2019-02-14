import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;
import java.util.Map.Entry;

public class Intervals {
	Vector<Integer> v = new Vector<>();

	boolean duplicates(final int[] a)
	{
	  Set<Integer> lump = new HashSet<Integer>();
	  for (int i : a)
	  {
	    if (lump.contains(i)) return true;
	    lump.add(i);
	  }
	  return false;
	}
	
	 static int removeDuplicates(int arr[], int n) 
	    { 
		 if (n == 0 || n == 1) 
	            return n; 
	       
	        int j = 0; 
	       
	        for (int i = 0; i < n-1; i++) 
	            if (arr[i] != arr[i+1]) 
	                arr[j++] = arr[i]; 
	       
	        arr[j++] = arr[n-1]; 
	       
	        return j; 
	    } 
	 public static int[] eliminateDuplicates(int[] list) {
		// Arrays.sort(list);
		    int newLength = list.length;
		    for (int i = 1; i < list.length; i++) {
		        for (int j = 0; j < i; j++) {
		            if (list[i] == list[j]) {   
		                newLength--;
		                break;
		            }
		        }
		    }

		    int[] newArray = new int[newLength]; // create new array with new length
		    newArray[0] = list[0];  // 1st element goes to new array
		    int inx = 1;            // index for 2nd element of new array
		    boolean isDuplicate;

		    for (int i = 1; i < list.length; i++) {
		        isDuplicate = false;
		        for (int j = 0; j < i; j++) {
		            if (list[i] == list[j]) {  
		                isDuplicate = true;
		                break;
		            }
		        }
		        if (!isDuplicate) {     
		            newArray[inx] = list[i];
		            inx++;
		        }
		    }
		    return newArray;
		}
	//finds the intervals with consecutive numbers. In the for-cycle it checks all poosible cases for each element of the array
	public void checkCons(int[] a) {
		Arrays.sort(a);
		//we check to see if there are duplicates in the array
		if(duplicates(a)==true) {
			a=eliminateDuplicates(a);	        
		}
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (i != a.length - 1 && a[i] + 1 == a[i + 1]) {
				count++;
				v.addElement(a[i]);
			}
			if (i > 0 && i != a.length - 1 && a[i] + 1 != a[i + 1] && a[i] == a[i - 1] + 1) {
				count++;
				v.addElement(a[i]);
				String s = "[" + v.get(0) + ", " + v.get(v.size() - 1) + "]" + " with consecutive count of " + count;
				count = 0;
				v.clear();
				System.out.println(s);
			}
			if (i > 0 && i != a.length - 1 && a[i] + 1 != a[i + 1] && a[i] != a[i - 1] + 1) {
				System.out.println("[" + a[i] + ", " + a[i] + "] with consecutive count of 1");
			}
			if (i == 0 && a[i] + 1 != a[i + 1]) {
				System.out.println("[" + a[i] + ", " + a[i] + "] with consecutive count of 1");
			}
			if (i == a.length - 1 && a[i] != a[i - 1] + 1) {
				System.out.println("[" + a[i] + ", " + a[i] + "] with consecutive count of 1");
			}
			if (i == a.length - 1 && a[i] == a[i - 1] + 1) {
				count++;
				v.addElement(a[i]);
				String s = "[" + v.get(0) + ", " + v.get(v.size() - 1) + "]" + " with consecutive count of " + count;
				count = 0;
				v.clear();
				System.out.println(s);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Integer> vec = new Vector<>();
		Intervals obj = new Intervals();
		System.out.println("Ener a number on each line and write exit when you want to quit");
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			if (s.hasNextInt()) {
				int value = s.nextInt();
				vec.add(value);
			} else
				break;
		}

		int[] arr = new int[vec.size()];

		for (int i = 0; i < vec.size(); i++) {
			arr[i] = vec.get(i);
		}		
			obj.checkCons(arr);
		
	}

}
