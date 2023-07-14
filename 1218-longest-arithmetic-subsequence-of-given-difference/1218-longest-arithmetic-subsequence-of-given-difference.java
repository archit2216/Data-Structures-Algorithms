class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int max=1;
        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i]-difference)){
                hm.put(arr[i],hm.get(arr[i]-difference)+1);
            }else{
                hm.put(arr[i],1);
            }
            max=Math.max(max,hm.get(arr[i]));
        }
        return max;
    }
}