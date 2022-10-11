class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3){
            return false;
        }
        Stack<Integer> st=new Stack<>();
        int[] ngr=new int[nums.length];
        ngr[nums.length-1]=nums.length;
        st.push(nums.length-1);
        for(int i=nums.length-2;i>=0;i--){
            while(st.size()>0 && nums[st.peek()]<=nums[i]){
                st.pop();
            }
            if(st.size()==0){
                ngr[i]=nums.length;
            }else{
                ngr[i]=st.peek();
            }
            st.push(i);
        }
        
        int[] nsl=new int[nums.length];
        nsl[0]=-1;
        st=new Stack<>();
        st.push(0);
        for(int i=1;i<nums.length;i++){
            while(st.size()>0 && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.size()==0){
                nsl[i]=-1;
            }else{
                nsl[i]=st.peek();
            }
            st.push(i);
        }
        
        for(int i=1;i<nums.length-1;i++){
            if(nsl[i]!=-1 && ngr[i]!=nums.length){
                return true;
            }
        }
        return false;
    }
}