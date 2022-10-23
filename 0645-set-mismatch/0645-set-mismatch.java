class Solution {
    public int[] findErrorNums(int[] nums) {
        int rep=-1;
        int miss=-1;
        
        for(int i=0;i<nums.length;i++){
            int idx=Math.abs(nums[i])-1;
            if(nums[idx]<0){
                rep=Math.abs(nums[i]);
            }else{
                nums[idx]*=-1;
            }
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                miss=i+1;
            }
        }
        int[] ans=new int[2];
        ans[0]=rep;
        ans[1]=miss;
        return ans;
    }
}