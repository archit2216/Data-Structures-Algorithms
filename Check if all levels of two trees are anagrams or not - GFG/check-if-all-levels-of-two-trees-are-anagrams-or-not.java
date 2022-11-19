//{ Driver Code Starts
import java.io.*;
import java.util.*;


class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
    
    public static Node buildTree(String str)
    {
        // Corner Case
        if(str.length()==0 || str.charAt(0)=='N')
            return null;
        
        // Creating array of Strings from input 
        // String after spliting by space
        String ip[] = str.split(" ");
        
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        
        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        
        // Starting from the second element
        int i = 1;
        while(queue.size()>0 && i < ip.length)
        {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N"))
            {
                    
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
            if(!currVal.equals("N"))
            {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
    public static Node inputTree(BufferedReader br) throws IOException
    {
        return buildTree(br.readLine().trim());
    }
    
    public static void inorder(Node root)
    {
        if (root == null)
           return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            Node node1 = Node.inputTree(br);
            
            
            Node node2 = Node.inputTree(br);
            
            Solution obj = new Solution();
            boolean res = obj.areAnagrams(node1, node2);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static boolean areAnagrams(Node node1, Node node2) {
        if(node1==null && node2==null){
            return true;
        }
        if(node1==null || node2==null){
            return false;
        }
        if(node1.data!=node2.data){
            return false;
        }
        
        Queue<Node> q1=new ArrayDeque<>();
        Queue<Node> q2=new ArrayDeque<>();
        
        q1.add(node1);
        q2.add(node2);
        
        while(q1.size()>0 && q2.size()>0){
            Node rem1=q1.remove();
            Node rem2=q2.remove();
            
            int s1=q1.size();
            int s2=q2.size();
            if(s1!=s2){
                return false;
            }
            HashMap<Integer,Integer> hm1=new HashMap<>();
            HashMap<Integer,Integer> hm2=new HashMap<>();
            while(s1>0 && s2>0){
                if(rem1.left!=null){
                    if(hm1.containsKey(rem1.left.data)){
                        hm1.put(rem1.left.data,hm1.get(rem1.left.data)+1);
                    }else{
                        hm1.put(rem1.left.data,1);
                    }
                    q1.add(rem1.left);
                }
                if(rem1.right!=null){
                    if(hm1.containsKey(rem1.right.data)){
                        hm1.put(rem1.right.data,hm1.get(rem1.right.data)+1);
                    }else{
                        hm1.put(rem1.right.data,1);
                    }
                    q1.add(rem1.right);
                }
                if(rem2.left!=null){
                    if(hm2.containsKey(rem2.left.data)){
                        hm2.put(rem2.left.data,hm1.get(rem2.left.data)+1);
                    }else{
                        hm2.put(rem2.left.data,1);
                    }
                    q2.add(rem2.left);
                }
                if(rem2.right!=null){
                    if(hm2.containsKey(rem2.right.data)){
                        hm2.put(rem2.right.data,hm1.get(rem2.right.data)+1);
                    }else{
                        hm2.put(rem2.right.data,1);
                    }
                    q2.add(rem2.right);
                }
                s1--;
                s2--;
            }
            if(!hm1.equals(hm2)){
                return false;
            }
        }
        
        return true;
        // code here
    }
}  
