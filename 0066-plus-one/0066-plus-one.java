class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> al=new ArrayList<>();
        
        int carry=1;
        for(int i=digits.length-1;i>=0;i--){
            int sum=digits[i]+carry;
            if(sum>9){
                sum=sum%10;
                carry=1;
            }else{
                carry=0;
            }
            al.add(sum);
        }
        
        if(carry==1){
            al.add(carry);
        }
        Collections.reverse(al);
        int[] ans=new int[al.size()];
        for(int i=0;i<al.size();i++){
            ans[i]=al.get(i);
        }
        return ans;
    }
}