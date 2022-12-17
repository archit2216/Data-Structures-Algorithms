class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String s=tokens[i];
            if(s.length()==1 && (s.charAt(0)=='+' || s.charAt(0)=='/' || s.charAt(0)=='-' || s.charAt(0)=='*')){
                if(st.size()>1){
                    int num1=st.pop();
                    int num2=st.pop();
                    int num=0;
                    if(s.charAt(0)=='+'){
                        num=num2+num1;
                    }else if(s.charAt(0)=='/'){
                        num=num2/num1;
                    }else if(s.charAt(0)=='*'){
                        num=num2*num1;
                    }else{
                        num=num2-num1;
                    }
                    st.push(num);
                }
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.peek();
    }
}