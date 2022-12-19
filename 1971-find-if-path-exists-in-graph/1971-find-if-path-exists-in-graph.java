class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> graph,int src,int dest,boolean[] vis){
        if(src==dest){
            return true;
        }
        vis[src]=true;
        for(Integer edge:graph.get(src)){
            if(vis[edge]==false){
                if(dfs(graph,edge,dest,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited=new boolean[n];
        
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int src=edges[i][0];
            int dest=edges[i][1];
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }
        
        return dfs(graph,source,destination,visited);
    }
}