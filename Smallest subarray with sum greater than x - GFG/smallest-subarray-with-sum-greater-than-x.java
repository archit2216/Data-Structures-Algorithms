//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            // int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.smallestSubWithSum(a, n, m));
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int smallestSubWithSum(int nums[], int n, int target) {
        int size=0;
        int minSize=Integer.MAX_VALUE;
        int sum=0;
        int i=0;
        while(i<nums.length){
            if(sum>target){
                minSize=Math.min(size,minSize);
                while(sum>target){
                    if(sum>target){
                        minSize=Math.min(minSize,size);
                    }
                    sum-=nums[i-size];
                    size--;
                }
            }
            sum+=nums[i];
            size++;
            i++;
        }
        if(sum>target){
            while(i>=size && sum>target){
                if(sum>=target){
                    minSize=Math.min(minSize,size);
                }
                sum-=nums[i-size];
                size--;
            }
        }
        if(minSize==Integer.MAX_VALUE){
            return 0;
        }
        return minSize;
        // Your code goes here 
    }
}

