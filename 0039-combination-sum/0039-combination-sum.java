class Solution {
    List<List<Integer>> ans;
    public void solve(int idx,int[] arr,int tar,List<Integer> al){
        if(tar==0){
            ans.add(new ArrayList<>(al));
            return;
        }
        
        if(tar<0){
            return;
        }
        
        for(int i=idx;i<arr.length;i++){
            al.add(arr[i]);
            solve(i,arr,tar-arr[i],al);
            al.remove(al.size()-1);
        }
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans=new ArrayList<>();
        solve(0,candidates,target,new ArrayList<>());
        return ans;
    }
}