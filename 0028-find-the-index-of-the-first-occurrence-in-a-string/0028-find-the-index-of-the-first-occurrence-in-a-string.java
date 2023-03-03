class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()){
            return -1;
        }
        StringBuilder sb=new StringBuilder(haystack.substring(0,needle.length()));
        if((sb.toString()).equals(needle)){
            return 0;
        }
        for(int i=needle.length();i<haystack.length();i++){
            sb.deleteCharAt(0);
            sb.append(haystack.charAt(i));
            if((sb.toString()).equals(needle)){
                return i-needle.length()+1;
            }
        }
        return -1;
    }
}