//{ Driver Code Starts
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
            String S = read.readLine();
            String W = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.numberOfSubsequences(S,W));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int numberOfSubsequences(String s, String w){
        boolean[] visited=new boolean[s.length()];
        int ans=0;
        for(int i=0;i<s.length();i++){
            int k=0;
            for(int j=0;j<s.length();j++){
                if(visited[j]==false && s.charAt(j)==w.charAt(k)){
                    k++;
                    visited[j]=true;
                }
                if(k==w.length()){
                    break;
                }
            }
            if(k>=w.length()){
                ans++;
            }
        }
        return ans;
        // code here
    }
}