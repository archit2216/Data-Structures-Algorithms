class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> hs=new HashSet<>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        
        int[] arr=new int[26];
        int c=0;
        for(int i=0;i<k;i++){
            if(hs.contains(s.charAt(i))){
                c++;
            }
            arr[s.charAt(i)-'a']++;
        }
        int max=c;
        for(int i=k;i<s.length();i++){
            arr[s.charAt(i-k)-'a']--;
            if(hs.contains(s.charAt(i-k))){
                c--;
            }
            if(hs.contains(s.charAt(i))){
                c++;
            }
            arr[s.charAt(i)-'a']++;
            max=Math.max(max,c);
        }
        
        return max;
    }
}