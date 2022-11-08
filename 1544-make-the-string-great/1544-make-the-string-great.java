class Solution {
    public String makeGood(String s) {
        Stack<Character> st=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            boolean flag=true;
            if(st.size()>0 && (st.peek()==(char)(ch+32) || st.peek()==(char)(ch-32))){
                st.pop();
                flag=false;
            }
            
            if(flag){
               st.push(ch); 
            }
        }
        
        char[] ans=new char[st.size()];
        int i=ans.length-1;
        while(st.size()>0){
            ans[i]=st.pop();
            i--;
        }
        return new String(ans);
    }
}