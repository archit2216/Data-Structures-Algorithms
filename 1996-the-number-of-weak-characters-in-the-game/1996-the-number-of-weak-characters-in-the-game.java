class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,new Comparator<int[]>(){
            public int compare(int[] first,int[] second){
                if(first[0]==second[0]){
                    return first[1]-second[1];
                }
                return second[0]-first[0];
            }
        });
        
        int max=0;
        int count=0;
        for(int i=0;i<properties.length;i++){
            if(max>properties[i][1]){
                count++;
            }
            max=Math.max(max,properties[i][1]);
        }
        
        return count;
    }
}