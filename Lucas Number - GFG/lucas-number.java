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
                    Solution ob = new Solution();
                    System.out.println(ob.lucas(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long lucas(int n)
        {
            if(n==0){
                return 2;
            }
            if(n==1){
                return 1;
            }
            long mod=1000000007;
            
            long a=2;
            long b=1;
            long c=0;
            for(int i=2;i<=n;i++){
                c=((a%mod)+(b%mod))%mod;
                a=b;
                b=c;
            }
            
            return c%mod;
            //code here.
        }
        
};
