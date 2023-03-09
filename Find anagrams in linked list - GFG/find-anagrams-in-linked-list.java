//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node temp = node;
                Node.printList(temp, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<Node> findAnagrams(Node head, String s) {
        // code here
        int[] arr=new int[26];
        
        int[] Orig=new int[26];
        for(int i=0;i<s.length();i++){
            Orig[s.charAt(i)-'a']++;
        }
        
        ArrayList<Node> al=new ArrayList<>();
        Node curr=head;
        Node prev=head;
        int len=0;
        
        while(prev!=null && curr!=null){
            if(len>=s.length()){
                if(Arrays.equals(Orig,arr)){
                    Node th=null;
                    Node tt=null;
                    Node t1=prev;
                    int count=0;
                    while(t1!=null && count<s.length()){
                        Node forw=t1.next;
                        t1.next=null;
                        if(th==null){
                            th=t1;
                            tt=t1;
                        }else{
                            tt.next=t1;
                            tt=tt.next;
                        }
                        t1=forw;
                        count++;
                    }
                    
                    al.add(th);
                    prev=t1;
                    curr=t1;
                    len=0;
                    arr=new int[26];
                    arr[curr.data-'a']++;
                }else{
                    arr[prev.data-'a']--;
                    prev=prev.next;
                    arr[curr.data-'a']++;
                }
            }else{
                arr[curr.data-'a']++;
            }
            len++;
            curr=curr.next;
        }
        
        if(Arrays.equals(Orig,arr)){
            Node th=null;
            Node tt=null;
            Node t1=prev;
            int count=0;
            while(t1!=null && count<s.length()){
                Node forw=t1.next;
                t1.next=null;
                if(th==null){
                    th=t1;
                    tt=t1;
                }else{
                    tt.next=t1;
                    tt=tt.next;
                }
                t1=forw;
                count++;
            }
            
            al.add(th);
        }
        return al;
    }
}