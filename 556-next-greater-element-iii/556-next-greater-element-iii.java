class Solution {
    public int nextGreaterElement(int n) {
        if(n<10){
            return -1;
        }
        Stack<Character> st=new Stack<>();
        String s=n+"";
        int[] arr=new int[10];
        st.push(s.charAt(s.length()-1));
        arr[s.charAt(s.length()-1)-'0']++;
        
        int flag=Integer.MAX_VALUE;
        for(int i=s.length()-2;i>=0;i--){
            char ch=s.charAt(i);
            if(st.size()>0 && st.peek()>ch){
                flag=i;
                arr[ch-'0']++;
                break;
            }
            st.push(ch);
            arr[ch-'0']++;
        }
        
        if(flag==Integer.MAX_VALUE){
            return -1;
        }
        int num=(int)(s.charAt(flag)-'0');
        int req=Integer.MAX_VALUE;
        while(st.size()>0){
            if((int)(st.peek()-'0')>num && req>num){
                req=(int)(st.peek()-'0');
            }
            st.pop();
        }
        
        arr[req]--;
        String ans="";
        for(int i=0;i<flag;i++){
            char ch=s.charAt(i);
            ans+=ch;
        }
        ans+=req;
        for(int i=0;i<arr.length;i++){
            for(int j=arr[i];j>0;j--){
                ans+=i;
            }
        }
        if(Long.parseLong(ans)>Integer.MAX_VALUE){
            return -1;
        }
        return Integer.parseInt(ans);
        
    }
}