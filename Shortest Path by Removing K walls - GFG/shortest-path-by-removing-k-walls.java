//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(St[0]);
            int m = Integer.parseInt(St[1]);
            int k = Integer.parseInt(St[2]);
            
            int[][] mat = new int[n][m];
            
            for(int i=0; i<n; i++)
            {
                String S[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                    mat[i][j] = Integer.parseInt(S[j]);
            }

            Solution ob = new Solution();
            System.out.println(ob.shotestPath(mat,n,m,k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static class Pair{
        int row;
        int col;
        int steps;
        int kstate;
        Pair(int row,int col,int steps,int kstate){
            this.row=row;
            this.col=col;
            this.steps=steps;
            this.kstate=kstate;
        }
    }
    static boolean[][][] visited;
    static int shotestPath(int[][] grid, int n, int m, int k) {
        // code here
        if(k==0 && grid[0][0]==1){
            return -1;
        }
        visited=new boolean[grid.length][grid[0].length][k+1];
        visited[0][0][k]=true;
        Queue<Pair> q=new ArrayDeque<>();
        
        int[] xdash={-1,0,1,0};
        int[] ydash={0,1,0,-1};
        if(grid[0][0]==1){
            k--;
        }
        int min=0;
        q.add(new Pair(0,0,0,k));
        
        while(q.size()>0){
            Pair rem=q.remove();
            if(rem.row==grid.length-1 && rem.col==grid[0].length-1){
                return rem.steps;
            }
            
            for(int i=0;i<4;i++){
                int xnew=rem.row+xdash[i];
                int ynew=rem.col+ydash[i];
                
                if(xnew<0 || xnew>=grid.length || ynew<0 || ynew>=grid[0].length ){
                    continue;
                }
                int nk=rem.kstate;
                if(grid[xnew][ynew]==1){
                    nk--;
                }
                if(nk>=0 && !visited[xnew][ynew][nk]){
                    q.add(new Pair(xnew,ynew,rem.steps+1,nk));
                    visited[xnew][ynew][nk]=true;
                }
            }
        }
        return -1;
    }
}