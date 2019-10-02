import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Vector;
public class Keys {
	Vector<Integer> v=new Vector<>();
	
	
	public boolean duplicates(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					return true;
				}
			}
		}
		return false;
	}
	public static int[] eliminateDuplicates(int[] list) {
		int newLength=list.length;
		for(int i=1;i<list.length;i++) {
			for(int j=0;j<i;j++) {
				if(list[i]==list[j]) {
					newLength--;
					break;
				}
			}
		}
		
		int[] newArr=new int[newLength];
		newArr[0]=list[0];
		int index=1;
		boolean isDuplicate;
		
		for(int i=1;i<list.length;i++) {
			isDuplicate=false;
			for(int j=0;j<i;j++) {
				if(list[i]==list[j]) {
					isDuplicate=true;
					break;
				}
			}
			if(!isDuplicate) {
				//System.out.println(index+"  "+i);
				newArr[index]=list[i];
				index++;
			}
		}
		
		return newArr;
	}
	public void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public void checkCons(int[] arr) {
		Arrays.sort(arr);
		printArr(arr);
		if(duplicates(arr)) {
			arr=eliminateDuplicates(arr);
		}
		printArr(arr);
		int count;
		if(arr.length>1) {
			if(arr[0]+1!=arr[1]) {
				System.out.println("[" + arr[0] + ", " + arr[0] + "] with consecutive count of 1");
			}
			count=0;
			for (int i = 1; i < arr.length; i++) {
				if(arr[i]==arr[i-1]+1 && count==0) {
					System.out.print("["+arr[i-1]+",");
					count++;
				}
				if(arr[i]==arr[i-1]+1 && count!=0) {
					count++;
				}
				if(arr[i]!=arr[i-1]+1 && count!=0) {
					System.out.println(arr[i-1]+"] with consecutive count of "+count);
					count=0;
				}
				if(i!=arr.length-1 && arr[i]!=arr[i-1]+1 && arr[i]+1!=arr[i+1]) {
					System.out.println("[" + arr[i] + ", " + arr[i] + "] with consecutive count of 1");
				}
				if(i==arr.length-1 && arr[i]!=arr[i-1]+1) {
					System.out.println("[" + arr[i] + ", " + arr[i] + "] with consecutive count of 1");
				}
				if(i==arr.length-1 && arr[i]==arr[i-1]+1) {
					System.out.println(arr[i]+"] with consecutive count of "+count);
					count=0;
				}
			}
		}
		else
			System.out.println("[" + arr[0] + ", " + arr[0] + "] with consecutive count of 1");
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Vector<Integer> vec=new Vector<>();
		Keys obj=new Keys();
		/*
		Scanner s=new Scanner(System.in);
		while(s.hasNext()) {
			if(s.hasNextInt()) {
				int val=s.nextInt();
				vec.add(val);
			}
			else {
				break;
			}
		}
		
		int[] arr=new int[vec.size()];
		
		for(int i=0;i<vec.size();i++) {
			arr[i]=vec.get(i);
		}
		*/
		
		int[] arr ={5,5,5,5};
		obj.checkCons(arr);
	
	}

}
