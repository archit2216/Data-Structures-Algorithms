class Solution {
    public char findTheDifference(String s, String t) {
        int sums=0;
        int sumt=0;
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            sums+=(int)(c);
        }
        
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            sumt+=(int)(c);
        }
        
        return (char)(sumt-sums);
    }
}