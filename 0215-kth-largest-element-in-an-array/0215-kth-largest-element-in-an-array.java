class Solution {
    public int helper(int[] nums,int lo,int hi,int k){
        int pivot=nums[hi];
        int pivotIdx=partition(nums,lo,hi,pivot);
        
        if(k<pivotIdx){
            return helper(nums,lo,pivotIdx-1,k);
        }else if(k>pivotIdx){
            return helper(nums,pivotIdx+1,hi,k);
        }else{
            return pivot;
        }
    }
    public int partition(int[] nums,int lo,int hi,int pivot){
        int i=lo;
        int j=lo;
        while(i<=hi){
            if(nums[i]<=pivot){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j++;
            }else{
                i++;
            }
        }
        return j-1;
    }
    public int findKthLargest(int[] nums, int k) {
        int ans=helper(nums,0,nums.length-1,nums.length-k);
        return ans;
    }
}