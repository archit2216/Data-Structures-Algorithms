class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String x="";
        
        for(int i=0;i<s.length()/2;i++){
            x+=s.charAt(i);
            int j=i+1;
            while(j+x.length()<=s.length()){
                if(s.substring(j,j+x.length()).equals(x)){
                    j+=x.length();
                }else{
                    break;
                }
            }
            if(j>=s.length()){
                return true;
            }
        }
        return false;
    }
}