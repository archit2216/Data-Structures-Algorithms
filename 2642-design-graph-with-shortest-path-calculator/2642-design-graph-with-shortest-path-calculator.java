class Graph {
    public class Pair implements Comparable<Pair>{
        int node;
        int wt;
        Pair(int node,int wt){
            this.node=node;
            this.wt=wt;
        }
        
        public int compareTo(Pair o){
            return this.wt-o.wt;
        }
    }
    
    ArrayList<ArrayList<Pair>> graph;
    int vtc;
    public Graph(int n, int[][] edges) {
        vtc=n;
        graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int src=edges[i][0];
            int dest=edges[i][1];
            int cost=edges[i][2];
            Pair p=new Pair(dest,cost);
            graph.get(src).add(p);
        }
    }
    
    public void addEdge(int[] edge) {
        int src=edge[0];
        int dest=edge[1];
        int cost=edge[2];
        Pair p=new Pair(dest,cost);
        graph.get(src).add(p);
    }
    
    public int shortestPath(int node1, int node2) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        boolean[] vis=new boolean[vtc];
        pq.add(new Pair(node1,0));
        while(pq.size()>0){
            Pair rem=pq.remove();
            if(rem.node==node2){
                return rem.wt;
            }
            if(vis[rem.node]){
                continue;
            }else{
                vis[rem.node]=true;
                for(Pair p:graph.get(rem.node)){
                    if(!vis[p.node]){
                        pq.add(new Pair(p.node,rem.wt+p.wt));
                    }
                }
            }
        }
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */