class Solution {
    public int compress(char[] chars) {
        int count=1;
        char prev=chars[0];
        int j=1;
        for(int i=1;i<chars.length;i++){
            if(prev==chars[i]){
                count++;
            }else{
                if(count>1){
                    String n=count+"";
                    for(int x=0;x<n.length();x++){
                        chars[j]=n.charAt(x);
                        j++;
                    }
                }
                count=1;
                prev=chars[i];
                chars[j]=chars[i];
                j++;
            }
        }
        if(count>1){
            String n=count+"";
            for(int x=0;x<n.length();x++){
                chars[j]=n.charAt(x);
                j++;
            }
        }
        return j;
    }
}