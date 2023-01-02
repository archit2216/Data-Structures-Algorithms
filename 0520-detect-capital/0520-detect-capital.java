class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length()==1){
            return true;
        }
        
        int countL=0;
        int countU=0;
        boolean flag=false;
        if(word.charAt(0)>='A' && word.charAt(0)<='Z'){
                flag=true;
            }
        for(int i=1;i<word.length();i++){
            char ch=word.charAt(i);
            if(flag){
                if(ch>='a' && ch<='z'){
                    countL++;
                }else{
                    countU++;
                }
            }else{
                if(ch>='A' && ch<='Z'){
                    return false;
                }else{
                    countL++;
                }
            }
        }
        if(countL==word.length()-1){
            return true;
        }
        if(countU==word.length()-1){
            return true;
        }
        return false;
    }
}