//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int q = sc.nextInt();
            ArrayList<Long> query = new ArrayList<>();
            for(int i=0;i<q;i++){
                query.add(sc.nextLong());
            }
            Solution ob = new Solution();
                
            ArrayList<Integer> ans = ob.threeDivisors(query,q);
            for(int cnt : ans) {
                System.out.println(cnt);
            }
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Long> al;
    static boolean isPrime(long n){
        for(long i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    
    static void FillAl(long max){
        for(long i=2;i*i<=max;i++){
            if(isPrime(i)){
                if(i*i<=max){
                    al.add(i*i);
                }
            }
        }
    }
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        // al=new ArrayList<>();
        // long max=0;
        // for(int i=0;i<q;i++){
        //     max=Math.max(max,query.get(i));
        // }
        // FillAl(query.get(query.size()-1));
        
        ArrayList<Integer> ans=new ArrayList<>();
        int last=0;
        for(int i=0;i<q;i++){
            long n=query.get(i);
            int count=0;
            
            for(long j=2;j*j<=n;j++){
                if(isPrime(j)){
                    if(j*j<=n){
                        count++;
                        }
                    }
                }
            ans.add(count);
        }
        return ans;
        // code here
    }
}