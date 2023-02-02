class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] arr=new int[26];
        for(int i=0;i<order.length();i++){
            char ch=order.charAt(i);
            arr[ch-'a']=i;
        }

        for(int i=0;i<words.length;i++){
            String s1=words[i];
            for(int j=i+1;j<words.length;j++){
                String s2=words[j];
                
                int x=0;
                int y=0;
                boolean flag=false;
                while(x<s1.length() && y<s2.length()){
                    if(arr[s1.charAt(x)-'a']>arr[s2.charAt(y)-'a']){
                        return false;
                    }else if(arr[s1.charAt(x)-'a']<arr[s2.charAt(y)-'a']){
                        flag=true;
                        break;
                    }
                    x++;
                    y++;
                }
                if(x<s1.length() && !flag){
                    return false;
                }
            }
        }
        return true;
    }
}