class Solution {
    public class Pair implements Comparable<Pair>{
        int x;
        int ht;
        Pair(int x,int ht){
            this.x=x;
            this.ht=ht;
        }

        public int compareTo(Pair o){
            if(this.x!=o.x){
                return this.x-o.x;
            }
            return this.ht-o.ht;
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Pair> al=new ArrayList<>();

        for(int i=0;i<buildings.length;i++){
            int sp=buildings[i][0];
            int ep=buildings[i][1];
            int ht=buildings[i][2];
            al.add(new Pair(sp,-ht));
            al.add(new Pair(ep,ht));
        }

        Collections.sort(al);

        List<List<Integer>> ans=new ArrayList<>();
        TreeMap<Integer,Integer> hm=new TreeMap<>();
        hm.put(0,1);
        int curr=0;
        for(int i=0;i<al.size();i++){
            int x=al.get(i).x;
            int ht=al.get(i).ht;

            if(ht<0){
                if(hm.containsKey(-ht)){
                    int val=hm.get(-ht);
                    hm.put(-ht,val+1);
                }else{
                    hm.put(-ht,1);
                }
            }else{
                if(hm.get(ht)>0){
                    int val=hm.get(ht);
                    if(val==1){
                        hm.remove(ht);
                    }else{
                        hm.put(ht,val-1);
                    }
                }
            }

            if(curr!=hm.lastKey()){
                List<Integer> temp=new ArrayList<>();
                temp.add(x);
                temp.add(hm.lastKey());
                ans.add(temp);
                curr=hm.lastKey();
            }
        }
        return ans;
    }
}