class Solution {
    String[] codes={".",".","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> helper(String s){
        if(s.length()==1){
            String code=codes[s.charAt(0)-'0'];
            List<String> al=new ArrayList<>();
            for(int i=0;i<code.length();i++){
                al.add(code.charAt(i)+"");
            }
            return al;
        }
        char ch=s.charAt(0);
        String rem=s.substring(1);
        List<String> smallAns=helper(rem);
        
        String val=codes[ch-'0'];
        List<String> ans=new ArrayList<>();
        for(int i=0;i<val.length();i++){
            char c=val.charAt(i);
            for(String x:smallAns){
                ans.add(c+x+"");
            }
        }
        return ans;
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }
        List<String> ans=helper(digits);
        return ans;
    }
}