class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st=new Stack<>();
        st.push(temp.length-1);
        int[] ans=new int[temp.length];
        ans[temp.length-1]=0;
        for(int i=temp.length-2;i>=0;i--){
            while(st.size()>0 && temp[st.peek()]<=temp[i]){
                st.pop();
            }
            if(st.size()==0){
                ans[i]=0;
            }else{
                ans[i]=st.peek()-i;
            }
            st.push(i);
        }
        
        return ans;
    }
}