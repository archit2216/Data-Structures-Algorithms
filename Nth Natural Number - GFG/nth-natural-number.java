//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner ob=new Scanner(System.in);
		int t=ob.nextInt();
		while(t-->0)
		{
		    long n=ob.nextLong();
		    Solution ab=new Solution();
		    long k=ab.findNth(n);
		    System.out.println(k);
		}
	}
}

    

// } Driver Code Ends


//User function Template for Java

class Solution {
    long findNth(long N)
    {
        long c=1;
        long ans=0;
        while(N>0){
            long rem=N%9;
            ans+=rem*c;
            c*=10;
            N=N/9;
        }
        return ans;
        //code here
    }
}