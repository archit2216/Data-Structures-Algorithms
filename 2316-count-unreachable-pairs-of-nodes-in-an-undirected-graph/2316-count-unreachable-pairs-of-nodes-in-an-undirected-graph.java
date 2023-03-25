class Solution {
    public long nC2(long n){
        if(n<2){
            return 0;
        }else if(n==2){
            return 1;
        }else{
            return n*(n-1)/2;
        }
    }
    public void dfs(ArrayList<ArrayList<Integer>> graph,int src,boolean[] visited,long[] c){
        visited[src]=true;
        c[0]++;
        for(int edge:graph.get(src)){
            if(visited[edge]==false){
                dfs(graph,edge,visited,c);
            }
        }
    }
    public long countPairs(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] visited=new boolean[n];
        ArrayList<Long> al=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                long[] c=new long[1];
                dfs(graph,i,visited,c);
                long count=c[0];
                al.add(count);
            }
        }
        
        long ans=0;
        for(int i=0;i<al.size();i++){
            ans+=nC2(al.get(i));
        }
        ans=nC2(n)-ans;
        return ans;
    }
}