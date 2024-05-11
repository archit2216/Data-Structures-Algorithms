class Solution {
    public void nextPermutation(int[] nums) {
        int breakIdx=-1;
        
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                breakIdx=i;
                break;
            }
        }
        
        if(breakIdx==-1){
            int si=0;
            int ei=nums.length-1;
            while(si<=ei){
                int temp=nums[si];
                nums[si]=nums[ei];
                nums[ei]=temp;
                si++;
                ei--;
            }
            return;
        }
        int min=Integer.MAX_VALUE;
        int minIdx=-1;
        for(int i=breakIdx+1;i<nums.length;i++){
            if(nums[i]>nums[breakIdx] && min>nums[i]){
                min=nums[i];
                minIdx=i;
            }
        }
        
        int temp=nums[breakIdx];
        nums[breakIdx]=nums[minIdx];
        nums[minIdx]=temp;
        
        Arrays.sort(nums,breakIdx+1,nums.length);
   }
}