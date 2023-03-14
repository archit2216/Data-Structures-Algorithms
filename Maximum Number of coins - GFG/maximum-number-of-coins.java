//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>(N);
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(str[i]));
			}
			Solution obj = new Solution();
			System.out.println(obj.maxCoins(N, arr));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int maxCoins(int N, ArrayList<Integer> arr) {
		//Write your code here
		int[][] dp=new int[N][N];
        
        for(int g=0;g<dp.length;g++){
            for(int i=0,j=g;j<dp.length;i++,j++){
                int max=Integer.MIN_VALUE;
                for(int k=i;k<=j;k++){
                    int left=k==i?0:dp[i][k-1];
                    int right=k==j?0:dp[k+1][j];
                    int cost=arr.get(k);
                    if(i>0){
                        cost*=arr.get(i-1);
                    }
                    if(j<N-1){
                        cost*=arr.get(j+1);
                    }
                    max=Math.max(left+right+cost,max);
                }
                dp[i][j]=max;
            }
        }
        return dp[0][dp[0].length-1];
	}
}