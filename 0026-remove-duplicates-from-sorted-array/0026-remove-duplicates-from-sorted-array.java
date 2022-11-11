class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        int count=1;
        int j=1;
        int prev=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=prev){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                prev=nums[j];
                j++;
                count++;
            }
        }
        return count;
    }
}