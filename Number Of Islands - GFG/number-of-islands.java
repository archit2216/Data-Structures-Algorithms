//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    
    public void solve(int[][] arr,int i,int j,int key){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]!=key){
            return;
        }
        
        arr[i][j]++;
        solve(arr,i+1,j,key);
        solve(arr,i,j+1,key);
        solve(arr,i-1,j,key);
        solve(arr,i,j-1,key);
    }
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        
        int[][] arr=new int[rows][cols];
        
        int key=1;
        List<Integer> ans=new ArrayList<>();
        for(int k=0;k<operators.length;k++){
            int x=operators[k][0];
            int y=operators[k][1];
            arr[x][y]=key;
            int count=0;
           for(int i=0;i<arr.length;i++){
               for(int j=0;j<arr[0].length;j++){
                   if(arr[i][j]==key){
                       solve(arr,i,j,key);
                       count++;
                   }
               }
           }
           ans.add(count);
           key++;
        }
        return ans;
        //Your code here
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends