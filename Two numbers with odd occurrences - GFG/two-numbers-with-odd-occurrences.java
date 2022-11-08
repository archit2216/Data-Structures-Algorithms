//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
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

//User function Template for Java
class Solution
{
    public int[] twoOddNum(int arr[], int N)
    {
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<N;i++){
            if(hs.contains(arr[i])){
                hs.remove(arr[i]);
            }else{
                hs.add(arr[i]);
            }
        }
        
        List<Integer> al=new ArrayList<>();
        for(Integer x:hs){
            al.add(x);
        }
        Collections.sort(al,Collections.reverseOrder());
        int[] ans=new int[al.size()];
        for(int i=0;i<al.size();i++){
            ans[i]=al.get(i);
        }
        return ans;
        // code here
    }
}