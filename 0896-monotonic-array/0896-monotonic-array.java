class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length<=2){
            return true;
        }
        int i=0;
        while(i<nums.length-1 && nums[i]==nums[i+1]){
            i++;
        }
        if(i==nums.length-1){
            return true;
        }
        int prev=0; //0 means dec
        if(nums[i]<nums[i+1]){
            prev=1;  // 1 means int
        }
        
        while(i<nums.length-1){
            if(prev==0){
                if(nums[i]<nums[i+1]){
                    return false;
                }
            }else{
                if(nums[i]>nums[i+1]){
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}