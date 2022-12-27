//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
import java.lang.*;


class GFG {
	public static void main (String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine()); // input size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split("\\s+");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    Solve T = new Solve();
            long ans = T.maxArea(arr,n);
            System.out.println(ans);
		}
	}
}

// } Driver Code Ends


//User function Template for Java


class Solve{
    
    long maxArea(int A[], int len){
        long ans=0;
        long lmax=0;
        long rmax=0;
        int l=0;
        int r=len-1;
        while(l<r){
            lmax=Math.max(lmax,A[l]);
            rmax=Math.max(rmax,A[r]);
            int width=r-l;
            if(lmax<rmax){
                ans=Math.max(ans,lmax*width);
                l++;
            }else{
                ans=Math.max(ans,rmax*width);
                r--;
            }
        }
        return ans;
        // Code Here
        
    }
    
}