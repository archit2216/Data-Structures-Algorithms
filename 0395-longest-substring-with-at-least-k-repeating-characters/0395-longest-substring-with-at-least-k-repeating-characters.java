class Solution {
    public int helper(String s,int si,int ei,int k){
        if(si>=ei){
            return 0;
        }
        
        int[] arr=new int[26];
        boolean flag=true;
        for(int i=si;i<ei;i++){
            char ch=s.charAt(i);
            arr[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            if(arr[i]>0 && arr[i]<k){
                flag=false;
            }
        }
        if(flag){
            return ei-si;
        }
        
        int max=0;
        int start=si;
        for(int i=si;i<ei;i++){
            char ch=s.charAt(i);
            if(arr[ch-'a']<k){
                max=Math.max(max,helper(s,start,i,k));
                start=i+1;
            }
        }
        
        max=Math.max(max,helper(s,start,ei,k));
        return max;
    }
    public int longestSubstring(String s, int k) {
        if(k==1){
            return s.length();
        }
        if(s.length()==0){
            return 0;
        }
        
        return helper(s,0,s.length(),k);
    }
}