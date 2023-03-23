class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> graph,int src,boolean[] visited){
        visited[src]=true;
        for(Integer x:graph.get(src)){
            if(visited[x]==false){
                dfs(graph,x,visited);
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){
            return -1;
        }
        int c=0;
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
    
      for(int i = 0; i<n; i++)
         graph.add(new ArrayList<>());
    
      for(int[] arr:connections){
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                dfs(graph,i,visited);
                c++;
            }
        }
        return c-1;
    }
}