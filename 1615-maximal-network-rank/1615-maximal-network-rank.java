class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] edges=new int[n];
        int[][] adj=new int[n][n];
        
        for(int i=0;i<roads.length;i++){
            int src=roads[i][0];
            int dest=roads[i][1];
            edges[src]++;
            edges[dest]++;
            adj[src][dest]=1;
            adj[dest][src]=1;
        }
        
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                max=Math.max(max,edges[i]+edges[j]-adj[i][j]);
            }
        }
        return max;
    }
}