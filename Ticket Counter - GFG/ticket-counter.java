//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int k=Integer.parseInt(s[1]);
            Solution ob=new Solution();
            out.println(ob.distributeTicket(n,k));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public static int distributeTicket(int N,int k)
    {
        int i=1;
        int j=N;
        int count=0;
        while(i<j){
            if(count%2==0){
                if(i+k>=j){
                    while(i<j){
                        i++;
                    }
                    return i;
                }
                i+=k;
            }else{
                if(j-k<=i){
                    while(i<j){
                        j--;
                    }
                    return j;
                }
                j-=k;
            }
            count++;
        }
        
        if(count%2==0){
            return j;
        }
        return i;
    }
}