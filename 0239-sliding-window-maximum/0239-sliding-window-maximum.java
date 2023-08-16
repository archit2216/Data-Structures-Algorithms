class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Stack<Integer> st=new Stack<>();
        st.push(nums.length-1);
        int[] ngr=new int[nums.length];
        ngr[nums.length-1]=nums.length;
        for(int i=nums.length-2;i>=0;i--){
            while(st.size()>0 && nums[st.peek()]<nums[i]){
                st.pop();
            }
            if(st.size()==0){
                ngr[i]=nums.length;
            }else{
                ngr[i]=st.peek();
            }
            st.push(i);
        }
        
        int j=0;
        int[] ans=new int[nums.length-k+1];
        for(int i=0;i<nums.length-k+1;i++){
            if(j<i){
                j=i;
            }
            while(ngr[j]<i+k){
                j=ngr[j];
            }
            ans[i]=nums[j];
        }
        return ans;
    }
}