//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int solve(int n,int[] arr){
        int[] dp=new int[n];
        int[] lis=new int[n];
        lis[0]=1;
        for(int i=1;i<n;i++){
            int j=i-1;
            int maxVal=Integer.MIN_VALUE;
            while(j>=0){
                if(arr[j]<arr[i]){
                    maxVal=Math.max(maxVal,lis[j]);
                }
                j--;
            }
            if(maxVal!=Integer.MIN_VALUE){
                lis[i]=maxVal+1;
            }else{
                lis[i]=1;
            }
        }
        
        int[] lds=new int[n];
        lds[n-1]=1;
        for(int i=n-2;i>=0;i--){
            int j=i+1;
            int maxVal=Integer.MIN_VALUE;
            while(j<n){
                if(arr[j]<arr[i]){
                    maxVal=Math.max(maxVal,lds[j]);
                }
                j++;
            }
            if(maxVal!=Integer.MIN_VALUE){
                lds[i]=maxVal+1;
            }else{
                lds[i]=1;
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int width=lis[i]+lds[i]-1;
            max=Math.max(max,width);
        }
        return max;
    }
    public int LongestBitonicSequence(int[] arr)
    {
        int n=arr.length;
        int ans=solve(n,arr);
        return ans;
        // Code here
    }
}