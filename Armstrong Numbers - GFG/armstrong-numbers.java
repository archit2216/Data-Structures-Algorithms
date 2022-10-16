//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String armstrongNumber(int n){
        int num=n;
        int digits=0;
        while(num>0){
            digits++;
            num=num/10;
        }
        num=n;
        int sum=0;
        while(n>0){
            int x=n%10;
            sum+=((int)Math.pow(x,digits));
            n=n/10;
        }
        if(sum==num){
            return "Yes";
        }
        return "No";
        // code here
    }
}