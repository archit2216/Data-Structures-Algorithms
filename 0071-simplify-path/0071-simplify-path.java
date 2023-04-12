class Solution {
    public String simplifyPath(String path) {
        String[] arr=path.split("/");
        Stack<String> st=new Stack<>();
        st.push("/");
        for(String s:arr){
            if(s.equals(".")){
                continue;
            }else if(s.equals("..")){
                if(st.size()==1){
                    continue;
                }else{
                st.pop();
                st.pop();
                }
            }else if(s.trim().isEmpty()==false){
            st.push(s);
            st.push("/");
            }
        }
        if(st.size()>1){
            st.pop();
        }
        if(st.size()<=1){
            return "/";
        }
        String[] res=new String[st.size()];
        int i=st.size()-1;
        while(i>=0){
            res[i]=st.pop();
            i--;
        }
        String ans="";
        int x=0;
        while(x<res.length){
                ans+=res[x];
                 x++;
        }
        
        return ans;
    }
}