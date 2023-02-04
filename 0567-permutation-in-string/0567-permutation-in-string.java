class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        
        int[] arr=new int[26];
        int[] secArr=new int[26];
        for(int i=0;i<s1.length();i++){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(i);
            arr[ch2-'a']--;
            arr[ch1-'a']++;
        }
        
        boolean flag=true;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                flag=false;
            }
        }
        
        if(flag){
            return true;
        }
        
        for(int i=s1.length();i<s2.length();i++){
            char ch=s2.charAt(i);
            char chDel=s2.charAt(i-s1.length());
            arr[ch-'a']--;
            arr[chDel-'a']++;
            flag=true;
            for(int j=0;j<26;j++){
                if(arr[j]!=0){
                    flag=false;
                }
            }
            if(flag){
                return true;
            }
        }
        return flag;
    }
}