//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [][] costs = new int[n][k];
			for(int i = 0; i < n; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < k; j++) {
					costs[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.minCost(costs));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minCost(int [][] colors) {
		//Write your code here
		int mod=1000000007;
		
		int n=colors.length;
		int k=colors[0].length;
		if(k==1 && n>1){
		    return -1;
		}
		int[][] dp=new int[n][k];
        
        int min=Integer.MAX_VALUE;
        int smin=Integer.MAX_VALUE;
        for(int j=0;j<k;j++){
            dp[0][j]=colors[0][j];
            if(min>=colors[0][j]){
                smin=min;
                min=colors[0][j];
            }else if(min<colors[0][j] && smin>=colors[0][j]){
                smin=colors[0][j];
            }
        }
        
        for(int i=1;i<n;i++){
            int nmin=Integer.MAX_VALUE;
            int nsmin=Integer.MAX_VALUE;
            for(int j=0;j<k;j++){
                if(min==dp[i-1][j]){
                    dp[i][j]=((smin%mod)+(colors[i][j]%mod)%mod);
                }else{
                    dp[i][j]=((min%mod)+(colors[i][j]%mod)%mod);
                }
                if(nmin>=dp[i][j]){
                    nsmin=nmin;
                    nmin=dp[i][j];
                }else if(nsmin>=dp[i][j]){
                    nsmin=dp[i][j];
                }
            }
            min=nmin;
            smin=nsmin;
        }
        return min;
	}
}