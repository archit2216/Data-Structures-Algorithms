class Solution {
    
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
    public void partitionhelper(String s,List<List<String>> ans,String asf){
        if(s.length()==0){
            String[] newStr=asf.split(" ");
            List<String> al=Arrays.asList(newStr);
            ans.add(al);
            return;
        }
        
        for(int i=0;i<s.length();i++){
            String pre=s.substring(0,i+1);
            if(isPalindrome(pre)){
                 String rem=s.substring(i+1);
                partitionhelper(rem,ans,asf+pre+" ");
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        partitionhelper(s,ans,"");
        return ans;
    }
}