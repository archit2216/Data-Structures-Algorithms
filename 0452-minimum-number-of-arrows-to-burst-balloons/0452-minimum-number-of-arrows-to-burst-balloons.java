class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,new Comparator<int[]>(){
            public int compare(int[] first,int[] second){
                if(first[0]!=second[0]){
                    return first[0]<second[0]?-1:1;
                }
                return first[1]<second[1]?-1:1;
            }
        });
        
        int count=1;
        int min=points[0][1];
        
        for(int i=1;i<points.length;i++){
            if(points[i][0]>min){
                count++;
                min=points[i][1];
            }else{
                min=Math.min(min,points[i][1]);
            }
        }
        return count;
    }
}