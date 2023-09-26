class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st=new Stack<>();
        boolean[] exist=new boolean[26];
        int[] freq=new int[26];
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'a']--;
            if(exist[ch-'a']){
                continue;
            }
            while(st.size()>0 && freq[st.peek()-'a']>0 && st.peek()>ch){
                char removed=st.pop();
                exist[removed-'a']=false;
            }
            st.push(ch);
            exist[ch-'a']=true;
        }
        
        char[] ans=new char[st.size()];
        int i=st.size()-1;
        while(i>=0){
            ans[i]=st.pop();
            i--;
        }
        return new String(ans);
    }
}