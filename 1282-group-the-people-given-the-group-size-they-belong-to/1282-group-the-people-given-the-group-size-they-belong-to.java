class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        List<List<Integer>> ans=new ArrayList<>();
        
        for(int i=0;i<groupSizes.length;i++){
            if(hm.containsKey(groupSizes[i])){
                List<Integer> al=hm.get(groupSizes[i]);
                al.add(i);
                hm.put(groupSizes[i],al);
            }else{
                List<Integer> al=new ArrayList<>();
                al.add(i);
                hm.put(groupSizes[i],al);
            }
            if(hm.get(groupSizes[i]).size()==groupSizes[i]){
                ans.add(hm.get(groupSizes[i]));
                hm.remove(groupSizes[i]);
            }
        }
        
        return ans;
    }
}