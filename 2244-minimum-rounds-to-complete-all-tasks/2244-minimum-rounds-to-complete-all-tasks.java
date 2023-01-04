class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> fmap=new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            if(fmap.containsKey(tasks[i])){
                int val=fmap.get(tasks[i]);
                fmap.put(tasks[i],val+1);
            }else{
                fmap.put(tasks[i],1);
            }
        }
        int count=0;
        for(int k:fmap.keySet()){
            if(fmap.get(k)==1){
                return -1;
            }
            count+=(fmap.get(k)+2)/3;
        }
        return count;
    }
}