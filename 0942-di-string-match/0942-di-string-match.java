class Solution {
    public int[] diStringMatch(String s) {
        int[] arr=new int[s.length()+1];
        Stack<Integer> st=new Stack<>();
        int num=0;
        int idx=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='I'){
                arr[idx]=num;
                idx++;
                while(st.size()>0){
                    arr[idx]=st.pop();
                    idx++;
                }
                num++;
            }else{
                st.push(num);
                num++;
            }
        }
        arr[idx]=num;
        idx++;
        while(st.size()>0){
            arr[idx]=st.pop();
            idx++;
        }
        return arr;
    }
}