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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String S){
        // code here
        boolean[][] dp=new boolean[S.length()][S.length()];
        int max=1;
        String ans=S.charAt(0)+"";
        for(int g=0;g<S.length();g++){
            for(int i=0,j=g;j<S.length();i++,j++){
                if(g==0){
                    dp[i][j]=true;
                }else if(g==1){
                    if(S.charAt(i)==S.charAt(j)){
                        dp[i][j]=true;
                        if(max<j-i+1){
                            max=j-i+1;
                            ans=S.substring(i,j+1);
                        }
                    }
                }else{
                    if(S.charAt(i)==S.charAt(j) && dp[i+1][j-1]==true){
                        dp[i][j]=true;
                        if(max<j-i+1){
                            max=j-i+1;
                            ans=S.substring(i,j+1);
                        }
                    }else{
                        dp[i][j]=false;
                    }
                }
            }
        }
        return ans;
    }
}