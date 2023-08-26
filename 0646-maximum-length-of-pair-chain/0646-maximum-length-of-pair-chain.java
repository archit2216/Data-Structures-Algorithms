class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,new Comparator<int[]>(){
            public int compare(int[] first,int[] second){
                return first[1]-second[1];
            }
        });
        
        int count=0;
        int end=Integer.MIN_VALUE;
        for(int i=0;i<pairs.length;i++){
            if(pairs[i][0]>end){
                count++;
                end=pairs[i][1];
            }
        }
        return count;
    }
}