class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int fact=1;
        for(int i=2;i<=nums.length;i++){
            fact*=i;
        }
        
        List<Integer> al=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            al.add(nums[i]);
        }
        
        for(int i=0;i<fact;i++){
            int temp=i;
            List<Integer> newAl=new ArrayList<>(al);
            List<Integer> newAltwo=new ArrayList<>();
            for(int div=nums.length;div>=1;div--){
                int rem=temp%div;
                newAltwo.add(newAl.get(rem));
                newAl.remove(rem);
                temp/=div;
            }
            ans.add(newAltwo);
        }
        return ans;
    }
}