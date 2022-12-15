//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Position this line where user code will be pasted.
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.BalancedString(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static String BalancedString(int N) {
        StringBuilder sb=new StringBuilder();
        if(N%2==0){
            char ch='a';
            int x=0;
            int mod=N%26;
            N-=mod;
            while(N>0){
                sb.append((char)(ch+x));
                x++;
                if(x==26){
                    x=0;
                }
                N--;
            }
            int start=mod/2;
            int end=mod/2;
            
            for(int i=0;i<start;i++){
                sb.append((char)('a'+i));
            }
            
            for(int i=26-end;i<26;i++){
                sb.append((char)('a'+i));
            }
        }else{
            int sum=0;
            String s=N+"";
            for(int i=0;i<s.length();i++){
                int num=(int)(s.charAt(i)-'0');
                sum+=num;
            }
            char ch='a';
            int x=0;
            int mod=N%26;
            N-=mod;
            while(N>0){
                sb.append((char)(ch+x));
                x++;
                if(x==26){
                    x=0;
                }
                N--;
            }
            int start=0;
            int end=0;
            if(sum%2==0){
                start=(mod+1)/2;
                end=(mod-1)/2;
            }else{
                start=(mod-1)/2;
                end=(mod+1)/2;
            }
            for(int i=0;i<start;i++){
                sb.append((char)('a'+i));
            }
            
            for(int i=26-end;i<26;i++){
                sb.append((char)('a'+i));
            }
        }
        return sb.toString();
        // code here
    }
}