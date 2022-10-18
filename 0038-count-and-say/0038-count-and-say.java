class Solution {
    String a;
    public void helper(int n,String ans){
        if(n==1){
            a=ans;
            return;
        }
        int count=1;
        StringBuilder sb=new StringBuilder();
        
        for(int i=1;i<ans.length();i++){            
            if(ans.charAt(i)==ans.charAt(i-1)){
                count++;
            }else{
                sb.append(count);
                sb.append(ans.charAt(i-1));
                count=1;
            }
        }
        sb.append(count);
        sb.append(ans.charAt(ans.length()-1));
        
        helper(n-1,sb.toString());
    }
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        a="";
        
        String ans="1";
        helper(n,ans);
        return a;
    }
}