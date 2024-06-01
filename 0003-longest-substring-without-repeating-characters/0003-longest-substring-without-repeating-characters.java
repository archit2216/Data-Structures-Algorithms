class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int max=0;
        HashMap<Character,Integer> hm=new HashMap<>();
        while(i<s.length()){
            char ch=s.charAt(i);
            if(!hm.containsKey(ch)){
                hm.put(ch,i);
            }else{
                max=Math.max(max,i-j);
                j=Math.max(j,hm.get(ch)+1);
                hm.put(ch,i);
            }
            i++;
        }
        return Math.max(max,i-j);
    }
}