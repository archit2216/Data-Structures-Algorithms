class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr=new int[26];
        
        int total=0;
        for(int i=0;i<sentence.length();i++){
            char ch=sentence.charAt(i);
            arr[ch-'a']++;
            if(arr[ch-'a']==1){
                total++;
            }
        }
        if(total==26){
            return true;
        }
        return false;
        
    }
}