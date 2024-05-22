class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> hm=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],true);
        }
        
        for(Integer x:hm.keySet()){
            if(hm.containsKey(x-1)){
                hm.put(x,false);
            }
        }
        
        int ml=0;
        for(Integer x:hm.keySet()){
            if(hm.get(x)){
                int l=1;
                int temp=x;
                while(hm.containsKey(temp+1)){
                    l++;
                    temp++;
                }
                ml=Math.max(ml,l);
            }
        }
        return ml;
    }
}