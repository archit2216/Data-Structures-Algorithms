//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.downwardDigonal(n, matrix);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> downwardDigonal(int N, int arr[][])
    {
        ArrayList<Integer> al=new ArrayList<>();
        
        for(int g=0;g<N;g++){
            for(int i=0,j=g;j>=0;i++,j--){
                al.add(arr[i][j]);
            }
        }
        
        for(int g=1;g<N;g++){
            for(int i=g,j=N-1;i<N;i++,j--){
                al.add(arr[i][j]);
            }
        }
        
        return al;
        // code here 
    }
}
