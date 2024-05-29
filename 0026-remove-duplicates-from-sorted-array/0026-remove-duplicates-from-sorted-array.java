class Solution {
    public int removeDuplicates(int[] nums) {
        int i=1;
        int j=1;
        int last=nums[0];
        while(i<nums.length){
            if(nums[i]==last){
                i++;
            }else{
                last=nums[i];
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
                i++;
            }
        }
        return j;
    }
}