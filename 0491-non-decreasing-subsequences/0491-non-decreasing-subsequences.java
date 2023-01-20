class Solution {
    public void solve(HashSet<List<Integer>> hs,int idx,int[] nums,List<Integer> al){
        if(al.size()>=2){
            hs.add(new ArrayList<>(al));
        }
        
        for(int i=idx;i<nums.length;i++){
            if(al.size()==0 || al.get(al.size()-1)<=nums[i]){
                al.add(nums[i]);
                solve(hs,i+1,nums,al);
                al.remove(al.size()-1);
            }
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        HashSet<List<Integer>> hs=new HashSet<>();
        solve(hs,0,nums,new ArrayList<>());
        List ans=new ArrayList<>(hs);
        return ans;
    }
}