class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int si=i+1;
            int ei=nums.length-1;
            
            while(si<ei){
                if((long)((long)(nums[i])+(long)(nums[si])+(long)(nums[ei]))==0){
                    List<Integer> al=new ArrayList<>();
                    al.add(nums[i]);
                    al.add(nums[si]);
                    al.add(nums[ei]);
                    ans.add(al);
                    si++;
                    ei--;
                    while(si<ei && nums[si]==nums[si-1]){
                        si++;
                        continue;
                    }
                    while(si<ei && nums[ei]==nums[ei+1]){
                        ei--;
                        continue;
                    }
                }else if((long)((long)(nums[i])+(long)(nums[si])+(long)(nums[ei]))<0){
                    si++;
                }else{
                    ei--;
                }
            }
        }
        return ans;
    }
}