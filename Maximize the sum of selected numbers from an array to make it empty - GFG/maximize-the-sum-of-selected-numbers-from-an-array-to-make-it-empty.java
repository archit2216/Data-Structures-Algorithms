//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		     
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    Arrays.sort(arr);
		    Complete obj = new Complete();
		    int ans = obj.maximizeSum(arr, sizeOfArray);
		    System.out.println(ans);
		}
	}
}




// } Driver Code Ends


//User function Template for Java



class Complete{
    
   
    // Function for finding maximum and value pair
    public static int maximizeSum (int arr[], int n) {
        //Complete the function
        TreeMap<Integer,Integer> hm=new TreeMap<>();
        for(int i=0;i<n;i++){
            if(hm.containsKey(arr[i])){
                int val=hm.get(arr[i]);
                hm.put(arr[i],val+1);
            }else{
                hm.put(arr[i],1);
            }
        }
        
        int sum=0;
        while(hm.size()>0){
            int last=hm.lastKey();
            if(hm.get(last)==1){
                hm.remove(last);
            }else{
                int val=hm.get(last);
                hm.put(last,val-1);
            }
            sum+=last;
            if(hm.containsKey(last-1)){
                int val=hm.get(last-1);
                if(val==1){
                    hm.remove(last-1);
                }else{
                    hm.put(last-1,val-1);
                }
            }
        }
        return sum;
    }
    
    
}


