import java.util.Arrays;

public class Object {
	//n^3
	public void checkPith(int arr[]) {

		Arrays.sort(arr);
		boolean flag=false;
		for (int i = 0; i < arr.length-2; i++) {
			for (int j = i; j < arr.length-1; j++) {
				for (int j2 = j; j2 < arr.length; j2++) {
					if(Math.pow(arr[i], 2)+Math.pow(arr[j], 2)==Math.pow(arr[j2], 2)){
						flag=true;
						System.out.println("true "+arr[i]+" "+arr[j]+" "+arr[j2]);
					}
				}
			}
		}
      if(flag==false)
        System.out.println("false");     
        
	}
	
	//n^3
	 // Returns true if there is Pythagorean triplet in ar[0..n-1] 
    static boolean isTriplet(int ar[], int n) 
    { 
        for (int i=0; i<n; i++) 
        { 
            for (int j=i+1; j<n; j++) 
            {     
                for (int k=j+1; k<n; k++) 
                { 
                    // Calculate square of array elements 
                    int x = ar[i]*ar[i], y = ar[j]*ar[j], z = ar[k]*ar[k]; 
   
                    if (x == y + z || y == x + z || z == x + y) 
                        return true; 
                } 
            } 
        } 
   
        // If we reach here, no triplet found 
        return false; 
    } 
	
    //n^2
 // Returns true if there is a triplet with following property 
    // A[i]*A[i] = A[j]*A[j] + A[k]*[k] 
    // Note that this function modifies given array 
    static boolean isTriplet2(int arr[], int n) 
    { 
        // Square array elements 
        for (int i=0; i<n; i++) 
            arr[i] = arr[i]*arr[i]; 
   
        // Sort array elements 
        Arrays.sort(arr); 
   
        // Now fix one element one by one and find the other two 
        // elements 
        for (int i = n-1; i >= 2; i--) 
        { 
            // To find the other two elements, start two index 
            // variables from two corners of the array and move 
            // them toward each other 
            int l = 0; // index of the first element in arr[0..i-1] 
            int r = i-1; // index of the last element in arr[0..i-1] 
            while (l < r) 
            { 
                // A triplet found 
                if (arr[l] + arr[r] == arr[i]) 
                    return true; 
   
                // Else either move 'l' or 'r' 
                if (arr[l] + arr[r] < arr[i]) 
                   l++; 
                else
                   r--; 
            } 
        } 
   
        // If we reach here, then no triplet found 
        return false; 
    } 
	
	public void printVector(int arr[])
	{
		 for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]+" ");
		       }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]=new int[]{3, 1, 4, 6, 5};
		int arr2[] = {10, 4, 6, 12, 5};
		int arr3[] = {3, 4, 13, 12, 5};
		Object obj=new Object();
		obj.checkPith(arr);//true 3 4 5
		obj.checkPith(arr2);//false
		obj.checkPith(arr3);//true 3 4 5 true 5 12 13
		 int ar_size = arr3.length; 
		 if(isTriplet(arr3,ar_size)==true) 
	           System.out.println("Yes"); 
	        else
	           System.out.println("No");   
		 
		 if(isTriplet2(arr3,ar_size)==true) 
	           System.out.println("Yes"); 
	        else
	           System.out.println("No");  
		//obj.bubbleSort(arr2);
		//obj.printVector(arr2);//1 2 4 5 8 
	}

}
