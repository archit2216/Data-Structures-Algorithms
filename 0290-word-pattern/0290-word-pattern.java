class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] parts=s.split(" ");
        if(pattern.length()!=parts.length){
            return false;
        }
        
        HashSet<Character> hs=new HashSet<>();
        for(int i=0;i<pattern.length();i++){
            hs.add(pattern.charAt(i));
        }
        
        HashSet<String> hss=new HashSet<>();
        for(int i=0;i<parts.length;i++){
            hss.add(parts[i]);
        }
        
        if(hs.size()!=hss.size()){
            return false;
        }
        
        HashMap<Character,String> hm=new HashMap<>();
        for(int i=0;i<parts.length;i++){
            char ch=pattern.charAt(i);
            
            if(hm.containsKey(ch)){
                String val=hm.get(ch);
                if(val.equals(parts[i])==false){
                    return false;
                }
            }else{
                hm.put(ch,parts[i]);
            }
        }
        
        return true;
        
    }
}