//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine());
            String s[]=in.readLine().trim().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            long ans[]=ob.smallerSum(n,a);
            for(long i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public long[] smallerSum(int n,int arr[])
    {
        long[] ans=new long[arr.length];
        long[] prefix=new long[arr.length];
        
        int[] copy=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            copy[i]=arr[i];
        }
        
        Arrays.sort(copy);
        prefix[0]=copy[0];
        for(int i=1;i<arr.length;i++){
            prefix[i]=prefix[i-1]+copy[i];
        }
        
        for(int i=0;i<arr.length;i++){
            int beg=0;
            int end=arr.length-1;
            int idx=-1;
            while(beg<=end){
                int mid=beg+(end-beg)/2;
                if(arr[i]>copy[mid]){
                    idx=mid;
                    beg=mid+1;
                }else{
                    end=mid-1;
                }
            }
            if(idx!=-1){
                ans[i]=prefix[idx];
            }
        }
        return ans;
    }
}