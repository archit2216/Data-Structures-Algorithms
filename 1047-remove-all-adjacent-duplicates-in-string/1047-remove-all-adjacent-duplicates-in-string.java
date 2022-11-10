class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            if(st.size()>0 && st.peek()==s.charAt(i)){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }
        char[] arr=new char[st.size()];
        int i=st.size()-1;
        while(st.size()>0 && i>=0){
            arr[i]=st.pop();
            i--;
        }
        String x=new String(arr);
        return x;
    }
}