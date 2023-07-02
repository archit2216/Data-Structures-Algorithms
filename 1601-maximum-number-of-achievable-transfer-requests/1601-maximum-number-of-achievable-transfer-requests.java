class Solution {
    int max;
    public void solve(int idx,int n,int[][] requests,int count,int[] arr){
        if(idx==requests.length){
            for(int x:arr){
                if(x!=0){
                    return;
                }
            }
            max=Math.max(max,count);
            return;
        }
        
        arr[requests[idx][0]]--;
        arr[requests[idx][1]]++;
        solve(idx+1,n,requests,count+1,arr);
        arr[requests[idx][0]]++;
        arr[requests[idx][1]]--;
        
        solve(idx+1,n,requests,count,arr);
    }
    public int maximumRequests(int n, int[][] requests) {
        int[] arr=new int[n];
        max=0;
        solve(0,n,requests,0,arr);
        return max;
    }
}