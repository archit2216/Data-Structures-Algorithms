class Solution {
    public int minimumAverageDifference(int[] nums) {
        long s1=0;
        long s2=0;
        
        for(int i=0;i<nums.length;i++){
            s2+=nums[i];
        }
        
        long min=Long.MAX_VALUE;
        int flag=-1;
        for(int i=0;i<nums.length;i++){
            s1+=nums[i];
            s2-=nums[i];
            long a1=0;
            long a2=0;
            if(i==nums.length-1){
                a1=0;
                a2=s1/nums.length;
            }else{
                a1=s1/(i+1);
                a2=s2/(nums.length-i-1);
            }
            if(min>Math.abs(a2-a1)){
                min=Math.abs(a2-a1);
                flag=i;
            }
        }
        
        return flag;
    }
}