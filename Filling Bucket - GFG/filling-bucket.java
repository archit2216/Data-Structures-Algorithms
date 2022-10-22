//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.fillingBucket(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int fillingBucket(int N) {
        if(N==1){
            return 1;
        }
        int[] dp=new int[N+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        int mod=100000000;
        for(int i=3;i<=N;i++){
            dp[i]=(dp[i-1]%mod)+(dp[i-2]%mod);
            dp[i]%=mod;
        }
        
        return dp[N]%mod;
        // code here
    }
};