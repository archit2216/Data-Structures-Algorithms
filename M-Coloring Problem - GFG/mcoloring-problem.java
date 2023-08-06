//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean isSafe(int src,ArrayList<ArrayList<Integer>> graph,int[] colors,int col){
        for(Integer nbr:graph.get(src)){
            if(colors[nbr]==col){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int src,ArrayList<ArrayList<Integer>> graph,int[] colors,int m,int n){
        if(src==n){
            return true;
        }
        
        for(int i=1;i<=m;i++){
            if(isSafe(src,graph,colors,i)){
                colors[src]=i;
                if(dfs(src+1,graph,colors,m,n)){
                    return true;
                }
                colors[src]=0;
            }
        }
        return false;
    }
    public boolean graphColoring(boolean edges[][], int m, int n) {
        // Your code here
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            for(int j=0;j<edges[0].length;j++){
                if(edges[i][j]){
                    graph.get(i).add(j);
                }
            }
        }
        
        int[] colors=new int[n];
        return dfs(0,graph,colors,m,n);
    }
}