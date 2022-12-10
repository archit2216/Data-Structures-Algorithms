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
            int N = Integer.parseInt(read.readLine());
            String str = read.readLine();
            Solution ob = new Solution();

            System.out.println(ob.buildLowestNumber(str,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String buildLowestNumber(String s, int k) {
        // code here
        Stack<Character> st=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            while(st.size()>0 && k>0 && s.charAt(i)<st.peek()){
                st.pop();
                k--;
            }
            st.push(s.charAt(i));
        }
        while(st.size()>0 && k>0){
            st.pop();
            k--;
        }
        
        char[] arr=new char[st.size()];
        int i=arr.length-1;
        while(st.size()>0 && i>=0){
            arr[i]=st.pop();
            i--;
        }
        
        int d=0;
        while(d<arr.length && arr[d]=='0'){
            d++;
        }
        if(d==arr.length){
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        for(i=d;i<arr.length;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}