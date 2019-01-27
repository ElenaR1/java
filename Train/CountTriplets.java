import java.util.Arrays;

public class ReverseString {
	public ReverseString() {
		
	}
	public int countTriplets(int arr[], int sum) {
		int count=0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				for (int j2 = j+1; j2 < arr.length; j2++) {
					if(arr[i]+arr[j]+arr[j2]<12) {
						count++;
					}
				}
			}
		}
		
		
		return count;
	}
	public int countTriplets2(int arr[], int sum) {
		int n=arr.length;
		// Sort input array 
        Arrays.sort(arr); 
       
        // Initialize result 
        int ans = 0; 
       
        // Every iteration of loop counts triplet with 
        // first element as arr[i]. 
        for (int i = 0; i < n - 2; i++) 
        { 
            // Initialize other two elements as corner elements 
            // of subarray arr[j+1..k] 
            int j = i + 1, k = n - 1; 
       
            // Use Meet in the Middle concept 
            while (j < k) 
            { 
                // If sum of current triplet is more or equal, 
                // move right corner to look for smaller values 
                if (arr[i] + arr[j] + arr[k] >= sum) {
                	System.out.print("i: "+i+"--");
                	System.out.println("arr["+i+"] arr["+j+"] arr["+k+"] "+arr[i]+" "+arr[j]+" "+arr[k]);
                    k--; 
                }
                // Else move left corner 
                else
                { 
                    // This is important. For current i and j, there 
                    // can be total k-j third elements. 
                    ans += (k - j); 
                    j++; 
                } 
            } 
        } 
        return ans; 
        
}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]=new int[]{5, 1, 3, 4, 7}; 
		int sum = 12;  
		ReverseString obj=new ReverseString();
		System.out.println(obj.countTriplets(arr, sum));
		System.out.println(obj.countTriplets2(arr, sum));

	}

}
