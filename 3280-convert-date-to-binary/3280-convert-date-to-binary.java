class Solution {
    public String convertDateToBinary(String date) {
        String[] parts=date.split("-");
        String ans="";
        for(int i=0;i<parts.length;i++){
            String s=parts[i];
            int x=Integer.parseInt(s);
            String bi=Integer.toBinaryString(x);
            if(i!=parts.length-1){
                ans+=bi+'-';
            }else{
                ans+=bi;
            }
        }
        return ans;
        
    }
}