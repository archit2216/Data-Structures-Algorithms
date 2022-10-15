//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public class Pair{
        int d;
        int x;
        int y;
        Pair(int d,int x,int y){
            this.d=d;
            this.x=x;
            this.y=y;
        }
    }
    int shortestPath(int[][] grid, int[] src, int[] dest) {
        if(grid[dest[0]][dest[1]]==0 || grid[src[0]][src[1]]==0){
            return -1;
        }
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        Queue<Pair> q=new ArrayDeque<>();
        
        q.add(new Pair(0,src[0],src[1]));
        visited[src[0]][src[1]]=true;
        int[] dx={1,0,-1,0};
        int[] dy={0,1,0,-1};
        
        while(q.size()>0){
            Pair rem=q.remove();
            if(rem.x==dest[0] && rem.y==dest[1]){
                return rem.d;
            }
            for(int i=0;i<4;i++){
                int nx=rem.x+dx[i];
                int ny=rem.y+dy[i];
                
                if(nx>=0 && ny>=0 && nx<grid.length && ny<grid[0].length && visited[nx][ny]==false && grid[nx][ny]==1){
                    q.add(new Pair(rem.d+1,nx,ny));
                    visited[nx][ny]=true;
                }
            }
        }
        return -1;
        // Your code here
    }
}
