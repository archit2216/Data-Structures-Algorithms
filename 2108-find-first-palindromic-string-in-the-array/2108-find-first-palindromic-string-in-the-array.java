class Solution {
    public String firstPalindrome(String[] words) {
        for(int i=0;i<words.length;i++){
            String word=words[i];
            int si=0;
            int ei=word.length()-1;
            boolean flag=true;
            while(si<ei){
                if(word.charAt(si)!=word.charAt(ei)){
                    flag=false;
                    break;
                }
                si++;
                ei--;
            }
            if(flag){
                return word;
            }
        }
        return "";
    }
}