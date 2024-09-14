class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] arr=new boolean[26];
        for(int i=0;i<allowed.length();i++){
            arr[allowed.charAt(i)-'a']=true;
        }
        int count=0;
        for(int i=0;i<words.length;i++){
            String s=words[i];
            boolean flag=true;
            for(int j=0;j<s.length();j++){
                if(!arr[s.charAt(j)-'a']){
                    flag=false;
                    break;
                }
            }
            if(flag){
                count++;
            }
        }
        return count;
    }
}