//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.UniquePartitions(n);
            for(ArrayList<Integer>i: ans)
                for(int j: i)
                    System.out.print(j + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<ArrayList<Integer>> ans;
    public void solve(int n,ArrayList<Integer> al,int prev){
        if(n==0){
            ArrayList<Integer> newAl=new ArrayList<>(al);
            ans.add(newAl);
            return;
        }
        
        for(int i=prev;i>=1;i--){
            if(n-i>=0 && i<=prev){
                al.add(i);
                solve(n-i,al,i);
                al.remove(al.size()-1);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> UniquePartitions(int n)
    {
        ans=new ArrayList<>();
        solve(n,new ArrayList<>(),n);
        return ans;
        // Code here
    }
}