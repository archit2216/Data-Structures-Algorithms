class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k==0){
            return nums;
        }
        int[] arr=new int[nums.length];
        
        long[] prefix=new long[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        
        for(int i=0;i<nums.length;i++){
            if(i-k>=0 && i+k<nums.length){
                if(i-k==0){
                    arr[i]=(int)(prefix[i+k]/(2*k+1));
                }else{
                    arr[i]=(int)((prefix[i+k]-prefix[i-k-1])/(2*k+1));
                }
            }else{
                arr[i]=-1;
            }
        }
        return arr;
    }
}