class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i=0;
        int start=newInterval[0];
        int end=newInterval[1];
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        while(i<intervals.length && intervals[i][1]<start){
            ArrayList<Integer> al=new ArrayList<>();
            al.add(intervals[i][0]);
            al.add(intervals[i][1]);
            ans.add(al);
            i++;
        }
        while(i<intervals.length && intervals[i][0]<=end){
            start=Math.min(intervals[i][0],start);
            end=Math.max(intervals[i][1],end);
            i++;
        }
        ArrayList<Integer> al=new ArrayList<>();
        al.add(start);
        al.add(end);
        ans.add(al);
        while(i<intervals.length){
            al=new ArrayList<>();
            al.add(intervals[i][0]);
            al.add(intervals[i][1]);
            ans.add(al);
            i++;
        }
        
        int[][] finalAns=new int[ans.size()][2];
        for(i=0;i<finalAns.length;i++){
            finalAns[i][0]=ans.get(i).get(0);
            finalAns[i][1]=ans.get(i).get(1);
        }
        return finalAns;
    }
}