class Solution {
    int ans;
    public int dfs(int src,ArrayList<ArrayList<Integer>> graph,boolean[] vis,String s){
        vis[src]=true;
        int total=1;
        int max=0;
        int smax=0;
        for(Integer nbr:graph.get(src)){
            if(!vis[nbr]){
                int smallAns=dfs(nbr,graph,vis,s);
                if(s.charAt(src)!=s.charAt(nbr)){
                    if(smallAns>max){
                        smax=max;
                        max=smallAns;
                    }else if(smallAns>smax){
                        smax=smallAns;
                    }
                    total=Math.max(total,smallAns+1);
                }
            }
        }
        
        ans=Math.max(ans,max+smax+1);
        return total;
    }
    public int longestPath(int[] parent, String s) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        
        for(int i=0;i<parent.length;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=1;i<parent.length;i++){
            int src=parent[i];
            graph.get(src).add(i);
            graph.get(i).add(src);
        }
        
        boolean[] vis=new boolean[parent.length];
        ans=0;
        dfs(0,graph,vis,s);
        return ans;
    }
}