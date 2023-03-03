class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()){
            return -1;
        }
        
        for(int i=0;i<=haystack.length()-needle.length();i++){
            String sub=haystack.substring(i,needle.length()+i);
            if(sub.equals(needle)){
                return i;
            }
        }
        return -1;
    }
}