class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        
        int beg=0;
        int end=nums[nums.length-1];
        while(beg<end){
            int mid=(beg+end)/2;
            int count=0;
            for(int i=0;i<nums.length-1;i++){
                if(nums[i+1]-nums[i]<=mid){
                    count++;
                    i++;
                }
            }
            if(count>=p){
                end=mid;
            }else{
                beg=mid+1;
            }
        }
        return beg;
    }
}