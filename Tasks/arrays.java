import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

public class Keys {
	
	 static void display(int[] num)
     {
        for(int i=0; i<num.length;i++)
            System.out.print(num[i] + " ");
     }
	 static void sort(int[] num)
     {
       int i, j, temp;
       for(i=0; i<num.length-i;i++)
           { 
               for(j=0; j<num.length-i-1;j++)
                   {
                        if(num[j]>num[j+1])
                          {
                               temp = num[j];
                               num[j] = num[j+1];
                               num[j+1] = temp;
                          }
                   }
           }
     }


public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[]{5,4,9,0,1};
		sort(arr);
		display(arr);
    }
}
