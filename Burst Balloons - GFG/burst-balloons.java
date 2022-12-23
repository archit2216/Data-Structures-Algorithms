//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.maxCoins(n,a);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static int maxCoins(int n, int[] nums) {
    // code here
    int[][] dp=new int[nums.length][nums.length];
        
        for(int g=0;g<dp.length;g++){
            for(int i=0,j=g;j<dp.length;i++,j++){
                int max=Integer.MIN_VALUE;
                for(int k=i;k<=j;k++){
                    int left=k==i?0:dp[i][k-1];
                    int right=k==j?0:dp[k+1][j];
                    int cost=nums[k];
                    if(i>0){
                        cost*=nums[i-1];
                    }
                    if(j<nums.length-1){
                        cost*=nums[j+1];
                    }
                    max=Math.max(left+right+cost,max);
                }
                dp[i][j]=max;
            }
        }
        return dp[0][dp[0].length-1];
  }
}
     