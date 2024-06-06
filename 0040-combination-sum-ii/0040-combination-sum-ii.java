class Solution {
    List<List<Integer>> ans;
    public void solve(int idx,int[] nums,int tar,List<Integer> al){
        if(tar==0){
            ans.add(new ArrayList<>(al));
            return;
        }
        
        for(int i=idx;i<nums.length;i++){
            if(i!=idx && nums[i]==nums[i-1]){
                continue;
            }
            if(tar-nums[i]>=0){
                al.add(nums[i]);
                solve(i+1,nums,tar-nums[i],al);
                al.remove(al.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans=new ArrayList<>();
        Arrays.sort(candidates);
        solve(0,candidates,target,new ArrayList<>());
        return ans;
    }
}