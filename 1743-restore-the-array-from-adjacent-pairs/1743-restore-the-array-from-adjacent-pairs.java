class Solution {
    ArrayList<Integer> ans;
    public int[] restoreArray(int[][] adjacentPairs) {
        if(adjacentPairs.length==1){
            return adjacentPairs[0];
        }
        
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
        for(int i=0;i<adjacentPairs.length;i++){
            int src=adjacentPairs[i][0];
            int dest=adjacentPairs[i][1];
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
        int pot=0;
        for(Integer k:hm.keySet()){
            if(hm.get(k).size()==1){
                pot=k;
                break;
            }
        }
        
        HashSet<Integer> hs=new HashSet<>();
        ans.add(pot);
        hs.add(pot);
        while(ans.size()<adjacentPairs.length+1){
            for(Integer x:hm.get(pot)){
                if(!hs.contains(x)){
                    ans.add(x);
                    hs.add(x);
                    pot=x;
                }
            }
        }
        int[] finalArr=new int[adjacentPairs.length+1];
        for(int i=0;i<ans.size();i++){
            finalArr[i]=ans.get(i);
        }
        return finalArr;
    }
}