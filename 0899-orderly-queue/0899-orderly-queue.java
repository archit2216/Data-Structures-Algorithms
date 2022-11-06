class Solution {
    public String orderlyQueue(String s, int k) {
        if(s.length()==1){
            return s;
        }
        if(k>1){
            char[] arr=s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
        
        String min=s;
        for(int i=1;i<s.length();i++){
            String newStr=s.substring(i)+s.substring(0,i);
            if(min.compareTo(newStr)>0){
                min=newStr;
            }
        }
        
        return min;
    }
}