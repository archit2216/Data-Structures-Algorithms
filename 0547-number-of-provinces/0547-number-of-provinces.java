class Solution {
    public class Edge{
        int src;
        int nbr;
        Edge(int src,int nbr){
            this.src=src;
            this.nbr=nbr;
        }
    }
    public void getConnectedComps(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited){
        visited[src]=true;
        
        for(Edge edge:graph[src]){
            if(visited[edge.nbr]==false){
                getConnectedComps(graph,edge.nbr,dest,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V=isConnected.length;
        ArrayList<Edge>[] graph=new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(isConnected[i][j]==1 && i!=j){
                    int v1=i;
                    int v2=j;
                    graph[v1].add(new Edge(v1,v2));
                    graph[v2].add(new Edge(v2,v1));
                }
            }
        }
        boolean[] visited=new boolean[V];
        int count=0;
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(visited[i]==false){
                    getConnectedComps(graph,i,j,visited);
                        count++;
                }
            }
        }
        return count;
    }
}