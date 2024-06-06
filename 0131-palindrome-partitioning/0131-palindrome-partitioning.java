class Solution {
    List<List<String>> ans;
    public boolean isPalindrome(String s){
        int si=0;
        int ei=s.length()-1;
        while(si<ei){
            if(s.charAt(si)!=s.charAt(ei)){
                return false;
            }
            si++;
            ei--;
        }
        return true;
    }
    public void solve(String s,List<String> al){
        if(s.length()==0){
            ans.add(new ArrayList<>(al));
            return;
        }
        
        for(int i=0;i<s.length();i++){
            String pre=s.substring(0,i+1);
            if(isPalindrome(pre)){
                String post=s.substring(i+1);
                al.add(pre);
                solve(post,al);
                al.remove(al.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        ans=new ArrayList<>();
        solve(s,new ArrayList<>());
        return ans;
    }
}