//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.largestPrimeFactor(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean isPrime(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    static long largestPrimeFactor(int N) {
        // code here
        long max=2;
        for(int i=2;i*i<=N;i++){
            if(N%i==0){
                if(isPrime(N/i)){
                    max=Math.max(max,N/i);
                }else if(isPrime(i)){
                    max=Math.max(max,i);
                }
            }
        }
        if(isPrime(N)){
            max=N;
        }
        return max;
    }
}