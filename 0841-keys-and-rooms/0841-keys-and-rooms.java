class Solution {
    public boolean bfs(int src,HashMap<Integer,List<Integer>> graph,HashSet<Integer> visited){
        Queue<Integer> q=new ArrayDeque<>();
        
        q.add(src);
        
        while(q.size()>0){
            Integer rem=q.remove();
            if(visited.contains(rem)){
                continue;
            }else{
                visited.add(rem);
                for(Integer nbr:graph.get(rem)){
                    if(!visited.contains(nbr)){
                        q.add(nbr);
                    }
                }
            }
        }
        
        return visited.size()==graph.size();
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashMap<Integer,List<Integer>> graph=new HashMap<>();
        
        for(int i=0;i<rooms.size();i++){
            List<Integer> room=rooms.get(i);
            graph.put(i,room);
        }
        
        HashSet<Integer> visited=new HashSet<>();
        
        return bfs(0,graph,visited);
    }
}