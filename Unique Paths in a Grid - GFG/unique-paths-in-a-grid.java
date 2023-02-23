//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int solve(int[][] grid,int n,int m){
        long[][] dp=new long[n][m];
        int mod=1000000007;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(grid[i][j]==1){
                    if(i==n-1 && j==m-1){
                        dp[i][j]=grid[i][j];
                    }else if(j==m-1){
                        dp[i][j]=dp[i+1][j];
                    }else if(i==n-1){
                        dp[i][j]=dp[i][j+1];
                    }else{
                        dp[i][j]=(dp[i+1][j]%mod)+(dp[i][j+1]%mod);
                    }
                    dp[i][j]%=mod;
                }
            }
        }
        return (int)(dp[0][0]%mod);
    }
    static int uniquePaths(int n, int m, int[][] grid) {
        return solve(grid,n,m);
        // code here
    }
};