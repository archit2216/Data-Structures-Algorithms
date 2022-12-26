class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int prevTrue=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]+i>=prevTrue){
                prevTrue=i;
            }
        }
        if(prevTrue==0){
            return true;
        }
        return false;
    }
}