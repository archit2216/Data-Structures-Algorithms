class Solution {
    public String reverseWords(String str) {
        String[] arr=str.split(" ");
        
        String ans="";
        for(int i=0;i<arr.length;i++){
            char[] s=arr[i].toCharArray();
            int si=0;
            int ei=s.length-1;
            while(si<ei){
                char temp=s[si];
                s[si]=s[ei];
                s[ei]=temp;
                si++;
                ei--;
            }
            if(i==arr.length-1){
                ans+=String.valueOf(s);
            }else{
                ans+=String.valueOf(s)+" ";
            }
        }
        return ans;
    }
}