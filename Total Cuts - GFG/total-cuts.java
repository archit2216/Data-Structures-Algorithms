//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int K;
            K = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.totalCuts(N, K, A);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int totalCuts(int N, int K, int[] A) {
        // code here
        int[] lmax=new int[N];
        int[] rmin=new int[N];
        
        lmax[0]=A[0];
        rmin[A.length-1]=A[A.length-1];
        for(int i=1;i<N;i++){
            lmax[i]=Math.max(lmax[i-1],A[i]);
        }
        
        for(int i=A.length-2;i>=0;i--){
            rmin[i]=Math.min(rmin[i+1],A[i]);
        }
        
        int count=0;
        for(int i=0;i<A.length-1;i++){
            if(lmax[i]+rmin[i+1]>=K){
                count++;
            }
        }
        return count;
    }
}
        
