//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
	int [] nearestSmallestTower(int [] arr){
		//Write your code here
		
		Stack<Integer> st=new Stack<>();
		int[] nsl=new int[arr.length];
		nsl[0]=-1;
		st.push(0);
		for(int i=1;i<arr.length;i++){
		    while(st.size()>0 && arr[st.peek()]>=arr[i]){
		        st.pop();
		    }
		    if(st.size()==0){
		        nsl[i]=-1;
		    }else{
		        nsl[i]=st.peek();
		    }
		    st.push(i);
		}
		
		st=new Stack<>();
		int[] nsr=new int[arr.length];
		st.push(arr.length-1);
		nsr[arr.length-1]=arr.length;
		for(int i=arr.length-2;i>=0;i--){
		    while(st.size()>0 && arr[st.peek()]>=arr[i]){
		        st.pop();
		    }
		    if(st.size()==0){
		        nsr[i]=arr.length;
		    }else{
		        nsr[i]=st.peek();
		    }
		    st.push(i);
		}
		
		int[] ans=new int[arr.length];
		
		for(int i=0;i<arr.length;i++){
		    if(nsr[i]!=arr.length && nsl[i]!=-1){
    		    if(Math.abs(nsr[i]-i)>Math.abs(nsl[i]-i)){
    		        ans[i]=nsl[i];
    		    }else if(Math.abs(nsr[i]-i)<Math.abs(nsl[i]-i)){
    		        ans[i]=nsr[i];
    		    }else{
    		        if(arr[nsl[i]]>arr[nsr[i]]){
    		            ans[i]=nsr[i];
    		        }else{
    		            ans[i]=nsl[i];
    		        }
    		    }
		    }else{
		        if(nsr[i]==arr.length && nsl[i]==-1){
		            ans[i]=-1;
		        }else if(nsr[i]==arr.length){
		            ans[i]=nsl[i];
		        }else{
		            ans[i]=nsr[i];
		        }
		    }
		}
		return ans;
	}
}