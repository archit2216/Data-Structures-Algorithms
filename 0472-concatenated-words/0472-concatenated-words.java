class Solution {
    public boolean solve(HashSet<String> hs,String s){
        if(s.length()==0){
            return true;
        }
        
        for(int i=0;i<s.length();i++){
            String pre=s.substring(0,i+1);
            if(hs.contains(pre)){
                String newStr=s.substring(i+1);
                if(solve(hs,newStr)){
                    return true;
                }
            }
        }
        return false;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans=new ArrayList<>();
        HashSet<String> hs=new HashSet<>();
        
        for(int i=0;i<words.length;i++){
            hs.add(words[i]);
        }
        
        for(int i=0;i<words.length;i++){
            hs.remove(words[i]);
            if(solve(hs,words[i])){
                ans.add(words[i]);
            }
            hs.add(words[i]);
        }
        return ans;
    }
}