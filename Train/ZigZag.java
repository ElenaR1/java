import java.util.Arrays;

public class ReverseString {
	public ReverseString() {
		
	}
	
	//nlogn
	public void zigZag(int arr[]) {
		int n=arr.length;
		int newArr[]=new int[n];
		// Sort input array 
        Arrays.sort(arr); 
        newArr[0]=arr[0];
        if(n%2!=0) {
	       for (int i = 1; i < arr.length; i++) {
	    	   if(i%2==0) {
	    		  // System.out.println(i);
	    		   newArr[i]=arr[i-1];
	    	   }
	    	   else
	    		   newArr[i]=arr[i+1];
	       }
       }
        else
        {
        	 for (int i = 1; i < arr.length; i++) {
  	    	   if(i%2==0) {
  	    		  // System.out.println(i);
  	    		   newArr[i]=arr[i-1];
  	    	   }
  	    	   else if(i%2!=0 && i!=arr.length-1) {
  	    		   newArr[i]=arr[i+1];
  	    	   }
  	    	   else if(i%2!=0 && i==arr.length-1) {
  	    		   newArr[i]=arr[i];
  	    	   }
  	    		   
  	       }
        }
        
       for (int i = 0; i < newArr.length; i++) {
		System.out.print(newArr[i]+" ");
       }
        System.out.println();
	}
	
	//n
	public void zigZag2(int arr[]) {

        // Flag true indicates relation "<" is expected, 
        // else ">" is expected.  The first expected relation 
        // is "<" 
        boolean flag = true; 
          
        int temp =0; 
       
        for (int i=0; i<=arr.length-2; i++) 
        { 
            if (flag)  /* "<" relation expected */
            { 
                /* If we have a situation like A > B > C, 
                   we get A > B < C by swapping B and C */
                if (arr[i] > arr[i+1]) 
                { 
                    // swap 
                    temp  = arr[i]; 
                    arr[i] = arr[i+1]; 
                    arr[i+1] = temp; 
                } 
                  
            } 
            else /* ">" relation expected */
            { 
                /* If we have a situation like A < B < C, 
                   we get A < C > B by swapping B and C */
                if (arr[i] < arr[i+1]) 
                { 
                    // swap 
                    temp = arr[i]; 
                    arr[i] = arr[i+1]; 
                    arr[i+1] = temp; 
                } 
            } 
            flag = !flag; /* flip flag */
        }
        System.out.println(Arrays.toString(arr));     
        
	}
	public static void bubbleSort(int[] arr) {
	      int n = arr.length;
	      int temp = 0;

	      for(int i = 0; i < n; i++) {
	         for(int j=1; j < (n-i); j++) {
	            if(arr[j-1] > arr[j]) {
	               temp = arr[j-1];
	               arr[j-1] = arr[j];
	               arr[j] = temp;
	            }
	         }
	      }
	      
	}
	
	public void printVector(int arr[])
	{
		 for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]+" ");
		       }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]=new int[]{1,4,3,2};//1 3 2 4 
		int arr0[]=new int[]{1,4,3,2,6,5};//1 3 2 5 4 6 
		int arr1[]=new int[]{4, 3, 7, 8, 6, 2, 1};
		int arr2[]=new int[]{5,8,4,2,1};
		int arr3[]=new int[]{4, 3, 7, 8, 6, 2, 1};
		ReverseString obj=new ReverseString();
		obj.zigZag(arr);
		obj.zigZag(arr0);
		obj.zigZag(arr1);
		obj.zigZag2(arr3);
		
		//obj.bubbleSort(arr2);
		//obj.printVector(arr2);//1 2 4 5 8 
	}

}
