import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Vector;
public class Keys {
	public void bubbleSort(int[] arr) {
		int n=arr.length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	
	public void selectionSort(int[] arr) {
		int n=arr.length;
		for(int i=0;i<n-1;i++) {
			int minIdx=i;
			for(int j=i+1;j<n;j++) {
				if (arr[minIdx]>arr[j]) {
					minIdx=j;
				}
			}
			int temp=arr[minIdx];
			arr[minIdx]=arr[i];
			arr[i]=temp;
		}
	}
	
	public int binarySearch(int[] arr,int l,int r, int x) {
		int mid=(l+r)/2;
		if (arr[mid]==x) {
			return mid;
		}
		else if(x<arr[mid]) {
			return binarySearch(arr,l,mid-1,x);
		}
		else if(x>arr[mid]) {
			return binarySearch(arr,mid+1,r,x);
		}
		return -1;
	}
	public void print(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		int[] arr=new int[] {5,0,2,9,12,3};
		Keys obj=new Keys();
		obj.bubbleSort(arr);
		obj.print(arr);
		
		int[] arr2= {5,0,2,9,12,3};
		obj.selectionSort(arr2);
		obj.print(arr2);
		
		System.out.println(obj.binarySearch(arr2, 0, 6, 3));
		
	}

}
