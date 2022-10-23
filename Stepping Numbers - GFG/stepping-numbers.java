//{ Driver Code Starts
//Initial Template for Java


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
            String input_line[] = read.readLine().trim().split("\\s+");
            int  N = Integer.parseInt(input_line[0]);
            int  M = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            int ans = ob.steppingNumbers(N, M);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    int steppingNumbers(int n, int m){
        
        int left=0;
        int right=0;
        Queue<Integer> q=new ArrayDeque<>();
        for(int i=0;i<=9;i++){
            q.add(i);
        }
        
        int count=0;
        while(q.size()>0){
            int rem=q.remove();
            if(rem>=n && rem<=m){
                count++;
            }
            
            if(rem==0 || rem>=m){
                continue;
            }
            int lastDigit=rem%10;
            int front=rem*10+(lastDigit+1);
            int back=rem*10+(lastDigit-1);
            if(lastDigit==0){
                q.add(front);
            }else if(lastDigit==9){
                q.add(back);
            }else{
                q.add(front);
                q.add(back);
            }
        }
        return count;
        // code here
    }
}
