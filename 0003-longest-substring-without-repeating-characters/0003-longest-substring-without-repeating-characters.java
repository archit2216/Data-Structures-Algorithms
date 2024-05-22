class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1){
            return s.length();
        }
        
        int max=0;
        HashMap<Character,Integer> hm=new HashMap<>();
        int i=0;
        int j=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(hm.containsKey(ch)){
                i=Math.max(i,hm.get(ch)+1);
            }
            max=Math.max(max,j-i+1);
            hm.put(ch,j);
            j++;
        }
        return max;
    }
}