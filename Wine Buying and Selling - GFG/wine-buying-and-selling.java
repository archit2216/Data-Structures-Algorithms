//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int i=0; i<N; i++)
                arr[i] = sc.nextInt();
            
            Solution g = new Solution();
            long ans = g.wineSelling(arr,N);
            
            System.out.println(ans);
            T--;
        }
    }
}


// } Driver Code Ends
//User function Template for Java


class Solution {
    long wineSelling(int arr[],int N){
        // code here
        
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> negs=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                negs.add(i);
            }else if(arr[i]>0){
                pos.add(i);
            }
        }
        
        int i=0;
        int j=0;
        
        long sum=0;
        while(i<pos.size() && j<negs.size()){
            if(arr[pos.get(i)]>Math.abs(arr[negs.get(j)])){
                int ith=arr[pos.get(i)];
                int jth=arr[negs.get(j)];
                arr[pos.get(i)]=ith+jth;
                arr[negs.get(j)]=0;
                sum+=(Math.abs(pos.get(i)-negs.get(j))*Math.abs(jth));
                j++;
            }else if(arr[pos.get(i)]<Math.abs(arr[negs.get(j)])){
                int ith=arr[pos.get(i)];
                int jth=arr[negs.get(j)];
                arr[pos.get(i)]=0;
                arr[negs.get(j)]=ith+jth;
                sum+=(Math.abs(pos.get(i)-negs.get(j))*ith);
                i++;
            }else{
                int ith=arr[pos.get(i)];
                int jth=arr[negs.get(j)];
                arr[pos.get(i)]=0;
                arr[negs.get(j)]=0;
                sum+=(Math.abs(pos.get(i)-negs.get(j))*Math.abs(jth));
                i++;
                j++;
            }
        }
        return sum;
    }
}

//{ Driver Code Starts.
// } Driver Code Ends