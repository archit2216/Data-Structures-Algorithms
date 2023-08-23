class Solution {
    public String reorganizeString(String s) {
        char[] ans=new char[s.length()];
        
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        
        char prev='3';
        for(int i=0;i<s.length();i++){
            int max=0;
            char mainChar='1';
            for(int j=0;j<26;j++){
                if(max<arr[j] && prev!=((char)('a'+j))){
                    max=arr[j];
                    mainChar=(char)('a'+j);
                }
            }
            // System.out.println(mainChar+" "+prev);
            if(mainChar=='1'){
                return "";
            }
            ans[i]=mainChar;
            arr[mainChar-'a']--;
            prev=mainChar;
        }
        return new String(ans);
    }
}