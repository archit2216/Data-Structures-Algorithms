class Solution {
    public boolean isValid(String s) {
        if(s.length()==1){
            return false;
        }
        if(s.charAt(0)==')' || s.charAt(0)==']' || s.charAt(0)=='}'){
            return false;
        }
        if(s.charAt(s.length()-1)=='(' || s.charAt(s.length()-1)=='[' || s.charAt(s.length()-1)=='{'){
            return false;
        }
        
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            st.push(s.charAt(i));
            if(st.peek()==')'){
                st.pop();
                if(st.size()>0 && st.peek()=='('){
                    st.pop();
                }else{
                    return false;
                }
            }
            else if(st.peek()==']'){
                st.pop();
                if(st.size()>0 && st.peek()=='['){
                    st.pop();
                }else{
                    return false;
                }
            }
            else if(st.size()>0 && st.peek()=='}'){
                st.pop();
                if(st.peek()=='{'){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        if(st.size()>0){
            return false;
        }
        return true;
    }
}