//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    int ans = obj.specialPalindrome(s1,s2);
		    System.out.println(ans);
		    
		    
		    
		}
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    public static int palindrome(StringBuilder sb,int i,int j){
        int si=0;
        int ei=sb.length()-1;
        int count=0;
        while(si<ei){
            if(si>=i && si<=j && ei>=i && ei<=j){
                if(sb.charAt(si)!=sb.charAt(ei)){
                    return -1;
                }
            }else{
                if(sb.charAt(si)!=sb.charAt(ei)){
                    count++;
                }
            }
            si++;
            ei--;
        }
        return count;
    }
    public static int converts1Tos2(String s1,String s2,int si,int ei){
        StringBuilder sb=new StringBuilder(s1);
        
        int count=0;
        int j=0;
        for(int i=0;i<s1.length();i++){
            if(i>=si && i<=ei){
                if(s1.charAt(i)!=s2.charAt(j)){
                    sb.setCharAt(i,s2.charAt(j));
                    count++;
                }
                j++;
            }
        }
        
        int calc2=palindrome(sb,si,ei);
        if(calc2==-1){
            return Integer.MAX_VALUE;
        }
        count+=calc2;
        return count;
    }
    public  static int specialPalindrome(String s1, String s2){
       //Code Here
       if(s1.length()<s2.length()){
           return -1;
       }
       
       int min=Integer.MAX_VALUE;
       for(int i=0;i<=s1.length()-s2.length();i++){
           int calc=converts1Tos2(s1,s2,i,s2.length()+i-1);
           min=Math.min(min,calc);
       }
       if(min==Integer.MAX_VALUE){
           return -1;
       }
       return min;
    }
}