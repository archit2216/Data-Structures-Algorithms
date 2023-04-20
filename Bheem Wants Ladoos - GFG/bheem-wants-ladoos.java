//{ Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t > 0){
            String line = br.readLine().trim();
            Node root = buildTree(line);
            
            line = br.readLine().trim();
            String target_k[] = line.split(" ");
            int home = Integer.parseInt(target_k[0]);
            int k = Integer.parseInt(target_k[1]);
            
            Solution x = new Solution();
            System.out.println( x.ladoos(root, home, k) );
            t--;
        }
    }
}


// } Driver Code Ends


/*
// node structure:

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/

class Solution{
    static int getKLevelDown(Node root,int k,Node block){
        if(root==null || k<0 || root==block){
            return 0;
        }
        if(k==0){
            return root.data;
        }
        
        int ls=getKLevelDown(root.left,k-1,block);
        int rs=getKLevelDown(root.right,k-1,block);
        
        return ls+rs+root.data;
    }
    static ArrayList<Node> getPath(Node root,int home){
        if(root==null){
            return new ArrayList<>();
        }
        if(root.data==home){
            ArrayList<Node> al=new ArrayList<>();
            al.add(root);
            return al;
        }
        
        ArrayList<Node> ls=getPath(root.left,home);
        if(ls.size()>0){
            ls.add(root);
            return ls;
        }
        
        ArrayList<Node> rs=getPath(root.right,home);
        if(rs.size()>0){
            rs.add(root);
            return rs;
        }
        return new ArrayList<>();
    }
    static int ladoos(Node root, int home, int k){
        // Your code goes here
        ArrayList<Node> path=getPath(root,home);
        int ans=0;
        for(int i=0;i<path.size();i++){
            Node block=null;
            if(i!=0){
                block=path.get(i-1);
            }
            int x=getKLevelDown(path.get(i),k-i,block);
            ans+=x;
        }
        return ans;
    }
}

