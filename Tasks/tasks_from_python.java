import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Vector;
public class Keys {


	public void print(int[] arr) {
		int n=arr.length;
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public void printStringArr(String[] arr) {
		int n=arr.length;
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public void printMat(int[][] arr) {
		int n=arr.length;
		for(int i=0;i<n;i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public void printMats(String[][] arr) {
		int n=arr.length;
		for(int i=0;i<n;i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public int sum_of_digits(int a) {
		if(a<0) {
			a=a*(-1);
		}
		int s=0;
		while(a>0) {
			int digit=a%10;
			s+=digit;
			a/=10;
		}
		return s;
	}
	public int countDigits(int a) {
		int c=0;
		while(a>0) {
			int digit=a%10;
			c+=1;
			a/=10;
		}
		return c;
	}
	public int[] to_digits(int a) {
		//List<Integer> list = new ArrayList<>(); 
		int c=countDigits(a);
		int[] arr=new int[c];
		int ind=0;
		while(a>0) {
			int digit=a%10;
			//list.add(digit);
			arr[ind]=digit;
			ind++;
			a/=10;
		}
		//return list;
		//System.out.println(arr[0]);
		//Collections.reverse(arr);
		return arr;
	}
	public List<Integer> to_digits2(int a) {
		List<Integer> list = new ArrayList<>(); 

		int ind=0;
		while(a>0) {
			int digit=a%10;
			list.add(digit);
			ind++;
			a/=10;
		}
		Collections.reverse(list);
		return list;
	}
	
	public void func(int[] arr) {
		int n=arr.length;
		Map<Integer,Integer> d=new HashMap<Integer,Integer>();
		for(int i=0;i<n;i++) {
			if(d.get(arr[i])==null) {
				d.put(arr[i], 1);
			}
			else {
				int val=(int) d.get(arr[i]);
				d.put(arr[i], val+1);
				
			}
		}
		for (Map.Entry<Integer, Integer> val : d.entrySet()) { 
            System.out.println("Element " + val.getKey() + " "
                               + "occurs"
                               + ": " + val.getValue() + " times"); 
        } 
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Keys obj=new Keys();
		int n=1234;
		System.out.println(obj.sum_of_digits(n));
		int[] arr=obj.to_digits(n);
		obj.print(arr);
		List<Integer> l=obj.to_digits2(n);
		System.out.println(l);
		
		Dictionary d =new Hashtable();
		d.put(1, "aa");
		d.put(2, "bb");
		System.out.println(d.get(2));
		int[] arr2={1,0,3,1,3,4,3,4};
		obj.func(arr2);
		
	}

}
