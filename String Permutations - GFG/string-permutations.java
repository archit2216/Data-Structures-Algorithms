//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        ArrayList<String> ans=new ArrayList<>();
        
        int limit=1;
        for(int i=2;i<=S.length();i++){
            limit*=i;
        }
        
        for(int i=0;i<limit;i++){
            int temp=i;
            StringBuilder sb=new StringBuilder(S);
            String newStr="";
            for(int div=S.length();div>=1;div--){
                int rem=temp%div;
                int q=temp/div;
                newStr+=(sb.charAt(rem));
                sb.deleteCharAt(rem);
                temp=q;
            }
            ans.add(newStr);
        }
        Collections.sort(ans);
        return ans;
    }
	   
}
