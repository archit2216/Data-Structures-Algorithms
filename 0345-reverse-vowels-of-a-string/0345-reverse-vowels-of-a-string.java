class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb=new StringBuilder(s);
        
        int si=0;
        int ei=s.length()-1;
        
        HashSet<Character> hs=new HashSet<>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        hs.add('A');
        hs.add('E');
        hs.add('I');
        hs.add('O');
        hs.add('U');
        while(si<ei){
            if(hs.contains(s.charAt(si)) && hs.contains(s.charAt(ei))){
                char eith=s.charAt(ei);
                char sith=s.charAt(si);
                sb.setCharAt(si,eith);
                sb.setCharAt(ei,sith);
                si++;
                ei--;
            }else if(!hs.contains(s.charAt(si))){
                si++;
            }else if(!hs.contains(s.charAt(ei))){
                ei--;
            }
        }
        
        return sb.toString();
    }
}