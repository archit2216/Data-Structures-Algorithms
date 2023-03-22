class Solution {
    int min;
    boolean[] visited;
    public class Pair{
        int nbr;
        int wt;
        Pair(int nbr,int wt){
            this.nbr=nbr;
            this.wt=wt;
        }
    }
    public void connectedCompsOf1(HashMap<Integer,ArrayList<Pair>> graph,int src){
        visited[src]=true;
        if(graph.containsKey(src)){
            for(Pair p:graph.get(src)){
                min=Math.min(min,p.wt);
                if(!visited[p.nbr]){
                connectedCompsOf1(graph,p.nbr);
                }
            }
        }
    }
    public int minScore(int n, int[][] roads) {
        HashMap<Integer,ArrayList<Pair>> hm=new HashMap<>();
        for(int i=0;i<roads.length;i++){
            int src=roads[i][0];
            int dest=roads[i][1];
            int wt=roads[i][2];
            if(hm.containsKey(src)){
                ArrayList<Pair> p=hm.get(src);
                p.add(new Pair(dest,wt));
                hm.put(src,p);
            }else{
                ArrayList<Pair> p=new ArrayList<>();
                p.add(new Pair(dest,wt));
                hm.put(src,p);
            }
            if(hm.containsKey(dest)){
                ArrayList<Pair> p=hm.get(dest);
                p.add(new Pair(src,wt));
                hm.put(dest,p);
            }else{
                ArrayList<Pair> p=new ArrayList<>();
                p.add(new Pair(src,wt));
                hm.put(dest,p);
            }
        }
        
        visited=new boolean[n+1];
        min=Integer.MAX_VALUE;
        connectedCompsOf1(hm,1);
        return min;
    }
}