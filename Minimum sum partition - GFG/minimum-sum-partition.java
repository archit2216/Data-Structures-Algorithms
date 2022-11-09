//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

//User function Template for Java

class Solution
{
    
    public int solve(int[] arr,int n){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        boolean[][] dp=new boolean[n+1][sum+1];
        int minDiff=Integer.MAX_VALUE;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 && j>0){
                    dp[i][j]=false;
                }else if(j==0){
                    dp[i][j]=true;
                }else{
                    dp[i][j]=dp[i-1][j];
                    if(dp[i][j]==false && j>=arr[i-1]){
                        dp[i][j]=dp[i-1][j-arr[i-1]];
                    }
                }
                if(dp[i][j]){
                    int s1=j;
                    int s2=sum-j;
                    if(minDiff>Math.abs(s1-s2)){
                        minDiff=Math.abs(s1-s2);
                    }
                }
            }
        }
        
        return minDiff;
    }
	public int minDifference(int arr[], int n) 
	{ 
	    return solve(arr,n);
	    // Your code goes here
	} 
}