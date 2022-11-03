//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().removals(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int solve(int si,int ei,int[] arr,int k,Integer[] dp){
        if(si>ei){
            return arr.length;
        }
        if(arr[ei]-arr[si]<=k){
            return arr.length-(ei-si+1);
        }
        
        if(dp[si]!=null){
            return dp[si];
        }
        int x=solve(si+1,ei,arr,k,dp);
        int y=solve(si,ei-1,arr,k,dp);
        dp[si]=Math.min(x,y);
        return Math.min(x,y);
    }
    int removals(int[] arr, int n, int k) {
        Integer[] dp=new Integer[n];
        Arrays.sort(arr);
        int ans=solve(0,arr.length-1,arr,k,dp);
       return ans;
        // code here
    }
}