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
            
            
            int[] A = IntArray.input(br, N);
            
            
            int[] B = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.solve(N, A, B);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long solve(int N, int[] A, int[] B) {
        // code here
        
        int s1=0;
        int s2=0;
        ArrayList<Integer> oddA=new ArrayList<>();
        ArrayList<Integer> oddB=new ArrayList<>();
        ArrayList<Integer> evenA=new ArrayList<>();
        ArrayList<Integer> evenB=new ArrayList<>();
        for(int i=0;i<N;i++){
            s1+=A[i];
            s2+=B[i];
            
            if(A[i]%2==0){
                evenA.add(A[i]);
            }else{
                oddA.add(A[i]);
            }
            if(B[i]%2==0){
                evenB.add(B[i]);
            }else{
                oddB.add(B[i]);
            }
        }
        
        if(s1!=s2 || oddA.size()!=oddB.size() || evenA.size()!=evenB.size()){
            return -1;
        }
        Collections.sort(evenA);
        Collections.sort(oddA);
        Collections.sort(evenB);
        Collections.sort(oddB);
        long total=0;
        for(int i=0;i<oddA.size();i++){
            total+=(Math.abs(oddA.get(i)-oddB.get(i)))/2;
        }
        
        for(int i=0;i<evenA.size();i++){
            total+=(Math.abs(evenA.get(i)-evenB.get(i)))/2;
        }
        return total/2;
    }
}
        
