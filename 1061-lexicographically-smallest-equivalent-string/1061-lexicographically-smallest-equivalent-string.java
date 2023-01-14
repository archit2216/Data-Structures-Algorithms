class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        HashMap<Character,TreeSet<Character>> hm=new HashMap<>();
        
        for(int i=0;i<s1.length();i++){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(i);
            if(hm.containsKey(ch1)){
                TreeSet<Character> hs=hm.get(ch1);
                hs.add(ch2);
                hm.put(ch1,hs);
            }else if(!hm.containsKey(ch1)){
                TreeSet<Character> hs=new TreeSet<>();
                hs.add(ch2);
                hm.put(ch1,hs);
            }
            if(hm.containsKey(ch2)){
                TreeSet<Character> hs=hm.get(ch2);
                hs.add(ch1);
                hm.put(ch2,hs);
            }else if(!hm.containsKey(ch2)){
                TreeSet<Character> hs=new TreeSet<>();
                hs.add(ch1);
                hm.put(ch2,hs);
            }
        }
        
        for(char ch:hm.keySet()){
            TreeSet<Character> hs=hm.get(ch);
            for(char c:hs){
                TreeSet<Character> hsC=hm.get(c);
                for(char ch1:hs){
                    hsC.add(ch1);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<baseStr.length();i++){
            char ch=baseStr.charAt(i);
            if(hm.containsKey(ch) && ch>hm.get(ch).first()){
                ch=hm.get(ch).first();
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}