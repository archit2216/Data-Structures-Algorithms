class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> hs=new HashSet<>();
        
        for(int i=0;i<arr1.length;i++){
            int temp=arr1[i];
            while(temp>0){
                hs.add(temp);
                temp/=10;
            }
        }
        int max=0;
        for(int i=0;i<arr2.length;i++){
            int num=arr2[i];
            while(num>0){
                if(hs.contains(num)){
                    String x=num+"";
                    max=Math.max(max,x.length());
                    break;
                }
                num/=10;
            }
        }
        return max;
    }
}