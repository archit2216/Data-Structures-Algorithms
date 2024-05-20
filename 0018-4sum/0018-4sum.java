class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        HashSet<List<Integer>> hs=new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                int si=j+1;
                int ei=nums.length-1;
                while(si<ei){
                    if(((long)(nums[i])+(long)(nums[j])+(long)(nums[si])+(long)(nums[ei]))==(long)(target)){
                        List<Integer> al=new ArrayList<>();
                        al.add(nums[i]);
                        al.add(nums[j]);
                        al.add(nums[si]);
                        al.add(nums[ei]);
                        if(!hs.contains(al)){
                            hs.add(al);
                            ans.add(al);
                        }
                        si++;
                        ei--;
                    }else if(nums[i]+nums[j]+nums[si]+nums[ei]<target){
                        si++;
                    }else{
                        ei--;
                    }
                }
            }
        }
        return ans;
    }
}