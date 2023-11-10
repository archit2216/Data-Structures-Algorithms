class Solution {
    ArrayList<Integer> ans;
    public void dfs(int src,HashMap<Integer,ArrayList<Integer>> graph,HashSet<Integer> vis){
        vis.add(src);
        ans.add(src);
        for(Integer nbr:graph.get(src)){
            if(!vis.contains(nbr)){
                dfs(nbr,graph,vis);
            }
        }
    }
    public int[] restoreArray(int[][] adjacentPairs) {
        if(adjacentPairs.length==1){
            return adjacentPairs[0];
        }
        
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<adjacentPairs.length;i++){
            int src=adjacentPairs[i][0];
            int dest=adjacentPairs[i][1];
            hs.add(src);
            hs.add(dest);
            if(hm.containsKey(src)){
                ArrayList<Integer> al=hm.get(src);
                al.add(dest);
                hm.put(src,al);
            }else if(!hm.containsKey(src)){
                ArrayList<Integer> al=new ArrayList<>();
                al.add(dest);
                hm.put(src,al);
            }
            
            if(hm.containsKey(dest)){
                ArrayList<Integer> al=hm.get(dest);
                al.add(src);
                hm.put(dest,al);
            }else if(!hm.containsKey(dest)){
                ArrayList<Integer> al=new ArrayList<>();
                al.add(src);
                hm.put(dest,al);
            }
        }
        ans=new ArrayList<>();
        HashSet<Integer> vis=new HashSet<>();
        for(Integer x:hs){
            if(hm.containsKey(x) && hm.get(x).size()==1){
                dfs(x,hm,vis);
                break;
            }
        }
        int[] finalArr=new int[adjacentPairs.length+1];
        for(int i=0;i<ans.size();i++){
            finalArr[i]=ans.get(i);
        }
        return finalArr;
    }
}