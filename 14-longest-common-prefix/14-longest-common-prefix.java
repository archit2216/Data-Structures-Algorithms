class Solution {
    public String longestCommonPrefix(String[] strs) {
        int min=strs[0].length();
        for(int i=1;i<strs.length;i++){
            min=Math.min(min,strs[i].length());
        }
        
        String ans="";
     
        for(int i=0;i<min;i++){
            char ch=strs[0].charAt(i);
            boolean flag=true;
            for(int j=0;j<strs.length;j++){
                if(strs[j].charAt(i)!=ch){
                    flag=false;
                    return ans;
                }
            }
            if(flag){
                ans+=ch;
            }
        }
        return ans;
    }
}