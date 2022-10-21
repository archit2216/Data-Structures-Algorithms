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
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            int R = Integer.parseInt(input[0]); 
            int C = Integer.parseInt(input[1]); 
            String s1[] = read.readLine().trim().split("\\s+");
            int a[][] = new int[R][C];
            for(int i = 0;i < R*C;i++)
                a[i/C][i%C] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int[] ans = ob.reverseSpiral(R,C,a);
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
    public int[] reverseSpiral(int R, int C, int[][] arr)
    {
        ArrayList<Integer> al=new ArrayList<>();
        
        int count=1;
        
        int rs=0;
        int re=R-1;
        int cs=0;
        int ce=C-1;
        
        while(count<=R*C){
            if(count<=R*C){
                for(int i=cs;i<=ce;i++){
                    al.add(arr[rs][i]);
                    count++;
                }
            }
            rs++;
            if(count<=R*C){
                for(int i=rs;i<=re;i++){
                    al.add(arr[i][ce]);
                    count++;
                }
            }
            ce--;
            if(count<=R*C){
                for(int i=ce;i>=cs;i--){
                    al.add(arr[re][i]);
                    count++;
                }
            }
            re--;
            if(count<=R*C){
                for(int i=re;i>=rs;i--){
                    al.add(arr[i][cs]);
                    count++;
                }
            }
            cs++;
        }
        Collections.reverse(al);
        int[] ans=new int[al.size()];
        for(int i=0;i<al.size();i++){
            ans[i]=al.get(i);
        }
        return ans;
        
        // code here
    }
}