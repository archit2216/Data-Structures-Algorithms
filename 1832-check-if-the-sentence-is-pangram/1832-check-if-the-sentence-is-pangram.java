class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr=new int[26];
        
        for(int i=0;i<sentence.length();i++){
            char ch=sentence.charAt(i);
            arr[ch-'a']++;
        }
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]<1){
                return false;
            }
        }
        return true;
    }
}