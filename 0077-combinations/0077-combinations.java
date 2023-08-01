class Solution {
    List<List<Integer>> ans;
    public void solve(int lo,int n,int k,List<Integer> al){
        if(k==0){
            ans.add(new ArrayList<>(al));
            return;
        }
        if(lo>n){
            return;
        }
        for(int i=lo+1;i<=n;i++){
            al.add(i);
            solve(i,n,k-1,al);
            al.remove(al.size()-1);
        }
        
    }
    public List<List<Integer>> combine(int n, int k) {
        ans=new ArrayList<>();
        solve(0,n,k,new ArrayList<>());
        return ans;
    }
}