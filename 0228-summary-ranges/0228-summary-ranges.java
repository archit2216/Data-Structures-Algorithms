class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length==0){
            List<String> al=new ArrayList<>();
            return al;
        }
        if(nums.length==1){
            List<String> al=new ArrayList<>();
            al.add(nums[0]+"");
            return al;
        }
        List<String> al=new ArrayList<>();
        
        int end=nums[0];
        int start=nums[0];
        boolean flag=false;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]-1){
                end=nums[i+1];
                flag=true;
                continue;
            }else{
                if(flag){
                    al.add(start+"->"+end);
                }else{
                    al.add(start+"");
                }
                start=nums[i+1];
                end=nums[i+1];
                flag=false;
            }
        }
        if(flag){
            al.add(start+"->"+end);
        }else{
            al.add(nums[nums.length-1]+"");
        }
        return al;
    }
}