class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length()<p.length()){
            return new ArrayList<>();
        }
        
        int[] arr=new int[26];
        int[] newArr=new int[26];
        for(int i=0;i<p.length();i++){
            arr[p.charAt(i)-'a']++;
            newArr[s.charAt(i)-'a']++;
        }
        
        List<Integer> al=new ArrayList<>();
        if(Arrays.equals(arr,newArr)){
            al.add(0);
        }
        
        for(int i=p.length();i<s.length();i++){
            newArr[s.charAt(i)-'a']++;
            newArr[s.charAt(i-p.length())-'a']--;
            if(Arrays.equals(arr,newArr)){
                al.add(i-p.length()+1);
            }
        }
        return al;
    }
}