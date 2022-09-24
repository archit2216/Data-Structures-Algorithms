class Solution {
    public int[][] merge(int[][] Intervals) {
        Arrays.sort(Intervals,new Comparator<int[]>(){
         public int compare(int[] first,int[] second){
             if(first[0]==second[0]){
                 return second[1]-first[1];
             }
             return first[0]-second[0];
         }
        });
        ArrayList<int[]> ans=new ArrayList<>();
        int[] al=new int[2];
        al[0]=Intervals[0][0];
        al[1]=Intervals[0][1];
        ans.add(al);
        for(int i=1;i<Intervals.length;i++){
            if(Intervals[i][0]>=ans.get(ans.size()-1)[0] && Intervals[i][0]<=ans.get(ans.size()-1)[1]){
                if(Intervals[i][1]>ans.get(ans.size()-1)[1]){
                    ans.get(ans.size()-1)[1]=Intervals[i][1];
                }
            }else{
                al=new int[2];
                al[0]=Intervals[i][0];
                al[1]=Intervals[i][1];
                ans.add(al);
            }
        }
        int[][] arr=new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            arr[i][0]=ans.get(i)[0];
            arr[i][1]=ans.get(i)[1];
        }
        return arr;
    }
}