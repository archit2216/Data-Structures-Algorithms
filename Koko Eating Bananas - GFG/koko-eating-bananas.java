//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int Solve(int n, int[] piles, int h) {
        // code here
        
        int si=1;
        int ei=1000000000;
        
        while(si<ei){
            int mid=si+(ei-si)/2;
            int total=0;
            for(int pile:piles){
                total+=Math.ceil((pile*1.0)/mid);
            }
            
            if(total>h){
                si=mid+1;
            }else{
                ei=mid;
            }
        }
        return si;
    }
}
        
