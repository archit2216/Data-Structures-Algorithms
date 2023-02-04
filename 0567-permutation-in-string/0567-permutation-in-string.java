class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        
        int[] arr=new int[26];
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            arr[ch-'a']++;
        }
        for(int i=0;i<=s2.length()-s1.length();i++){
            String x=s2.substring(i,s1.length()+i);
            int[] secArr=new int[26];
            for(int j=0;j<x.length();j++){
                char ch=x.charAt(j);
                secArr[ch-'a']++;
            }
            if(Arrays.equals(arr,secArr)){
                return true;
            }
        }
        return false;
    }
}