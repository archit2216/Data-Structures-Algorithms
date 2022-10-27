//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            int[] ans = ob.leafNodes(arr, N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    ArrayList<Integer> al;
    public int getPivot(int[] arr,int si,int ei,int pivot){
        for(int i=si;i<=ei;i++){
            if(arr[i]>pivot){
                return i-1;
            }
        }
        
        return si;
    }
    public void solve(int[] arr,int si,int ei){
        if(si>ei){
            return;
        }
        if(si==ei){
            al.add(arr[si]);
            return;
        }
        int pivotIdx=getPivot(arr,si,ei,arr[si]);
        
        solve(arr,si+1,pivotIdx);
        solve(arr,pivotIdx+1,ei);
    }
    public int[] leafNodes(int arr[], int N)
    {
        al=new ArrayList<>();
        solve(arr,0,N-1);
        
        int[] ans=new int[al.size()];
        for(int i=0;i<al.size();i++){
            ans[i]=al.get(i);
        }
        return ans;
        // code here
    }
}