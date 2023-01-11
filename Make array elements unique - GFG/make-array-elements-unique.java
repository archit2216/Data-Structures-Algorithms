//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            
            int i = 0;
            int N = Integer.parseInt(br.readLine().trim());
        
            int arr[] = new int[(int)(N)];
            
            String inputLine2[] = br.readLine().trim().split(" ");
            for ( i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(inputLine2[i]);
            }
        
            Solution ob = new Solution();
            System.out.println(ob.minIncrements(arr,N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long minIncrements(int[] arr, int N) {
        // Code here
        Arrays.sort(arr);
        
        HashMap<Integer,Integer> hm=new HashMap<>();
        long count=0;
        for(int i=arr.length-1;i>=0;i--){
            int num=arr[i];
            int val=hm.getOrDefault(arr[i],0);
            if(val==0){
                hm.put(arr[i],1);
                continue;
            }else{
                while(hm.containsKey(num)){
                    num++;
                    count++;
                }
                hm.put(num,1);
            }
        }
        return count;
    }
}