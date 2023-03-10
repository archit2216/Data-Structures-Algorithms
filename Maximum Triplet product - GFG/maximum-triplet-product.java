//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    Long maxTripletProduct(Long arr[], int n)
    {
        if(n<=3){
            return arr[0]*arr[1]*arr[n-1];
        }
        
        long min1=Integer.MAX_VALUE;
        long min2=Integer.MAX_VALUE;
        long max1=Integer.MIN_VALUE;
        long max2=Integer.MIN_VALUE;
        long max3=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                if(min1>arr[i]){
                    min2=min1;
                    min1=arr[i];
                }else if(min1<=arr[i] && min2>arr[i]){
                    min2=arr[i];
                }
            }
            if(max1<arr[i]){
                max3=max2;
                max2=max1;
                max1=arr[i];
            }else if(max1>=arr[i] && max2<arr[i]){
                max3=max2;
                max2=arr[i];
            }else if(max1>=arr[i] && max2>=arr[i] && max3<arr[i]){
                max3=arr[i];
            }
        }
        
        if(min1!=Integer.MAX_VALUE && min2!=Integer.MAX_VALUE){
            if(min1*min2*max1>max1*max2*max3){
                return min1*min2*max1;
            }
        }
        return max3*max2*max1;
        // Complete the function
    }
}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    
		    Long[] arr = new Long[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Long.parseLong(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    Long res = obj.maxTripletProduct(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}


// } Driver Code Ends