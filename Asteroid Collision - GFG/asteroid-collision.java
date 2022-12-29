//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // code here
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<asteroids.length;i++){
            boolean flag=false;
            while(st.size()>0 && (st.peek()>0 && asteroids[i]<0)){
                if(Math.abs(st.peek())==Math.abs(asteroids[i])){
                    st.pop();
                    flag=true;
                    break;
                }
                else if(Math.abs(st.peek())<Math.abs(asteroids[i])){
                    st.pop();
                }
                else if(Math.abs(st.peek())>Math.abs(asteroids[i])){
                    flag=true;
                    break;
                }
            }
            if(flag==false){
                st.push(asteroids[i]);
            }
        }
        if(st.size()==0){
            return new int[0];
        }
        int[] ans=new int[st.size()];
        int i=st.size()-1;
        while(i>=0){
            ans[i]=st.pop();
           i--; 
        }
        return ans;
    }
}
