class Solution {
    public int longestPalindrome(String[] words) {
        
        HashMap<String,Integer> hm=new HashMap<>();
        int count=0;
        
        int unpaired=0;
        for(int i=0;i<words.length;i++){
            StringBuilder sb=new StringBuilder(words[i]);
            sb.reverse();
            String s=sb.toString();
            if(s.charAt(0)!=s.charAt(1)){
                if(hm.containsKey(s)){
                    int val=hm.get(s);
                    if(val==1){
                        hm.remove(s);
                    }else{
                        hm.put(s,val-1);
                    }
                    count+=4;
                    continue;
                }
                
                if(hm.containsKey(words[i])){
                    int val=hm.get(words[i]);
                    hm.put(words[i],val+1);
                }else{
                    hm.put(words[i],1);
                }
            }else{
                if(hm.containsKey(s)){
                    int val=hm.get(s);
                    if(val==1){
                        hm.remove(s);
                    }else{
                        hm.put(s,val-1);
                    }
                    count+=4;
                    unpaired--;
                }else{
                    hm.put(s,1);
                    unpaired++;
                }
            }
        }
        if(unpaired>0){
            unpaired=2;
        }
        return count+unpaired;
    }
}