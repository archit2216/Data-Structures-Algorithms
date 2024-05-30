class Solution {
    public int trap(int[] height) {
        Stack<Integer> st=new Stack<>();
        int ans=0;
        for(int i=0;i<height.length;i++){
            while(st.size()>0 && height[st.peek()]<=height[i]){
                int curr=height[st.pop()];
                if(st.size()==0){
                    break;
                }
                int rmax=height[i];
                int lmax=height[st.peek()];
                int width=i-st.peek()-1;
                ans+=(width*(Math.min(lmax,rmax)-curr));
            }
            st.push(i);
        }
        
        return ans;
    }
}