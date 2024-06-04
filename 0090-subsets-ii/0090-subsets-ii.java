class Solution {
    List<List<Integer>> ans;
    HashSet<List<Integer>> hs;
    public void subsetSum(int idx,int[] nums,List<Integer> al){
        ans.add(new ArrayList<>(al));
        
        for(int i=idx;i<nums.length;i++){
            if(i!=idx && nums[i]==nums[i-1]){
                continue;
            }
            al.add(nums[i]);
            subsetSum(i+1,nums,al);
            al.remove(al.size()-1);
        }
        
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans=new ArrayList<>();
        hs=new HashSet<>();
        Arrays.sort(nums);
        subsetSum(0,nums,new ArrayList<>());
        return ans;
    }
}