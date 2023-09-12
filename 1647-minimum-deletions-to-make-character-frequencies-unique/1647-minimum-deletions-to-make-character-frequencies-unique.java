class Solution {
    public int minDeletions(String s) {
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        
        int count=0;
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<26;i++){
            if(arr[i]>0 && !hs.contains(arr[i])){
                hs.add(arr[i]);
            }else if(hs.contains(arr[i])){
                while(arr[i]>0 && hs.contains(arr[i])){
                    arr[i]--;
                    count++;
                }
                if(arr[i]>0){
                    hs.add(arr[i]);
                }
            }
        }
        return count;
    }
}