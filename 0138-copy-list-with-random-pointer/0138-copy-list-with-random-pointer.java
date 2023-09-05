/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
    public void copylist(Node head){
        if(head==null){
            return;
        }
        
        Node curr=head;
        while(curr!=null){
            Node forw=curr.next;
            Node node=new Node(curr.val);
            node.next=curr.next;
            curr.next=node;
            
            curr=forw;
        }
    }
    
    public void copyRandomPointers(Node head){
        if(head==null){
            return;
        }
        
        Node curr=head;
        while(curr!=null){
            Node Random=curr.random;
            if(Random!=null){
                curr.next.random=Random.next;
            }
            curr=curr.next.next;
        }
    }
    
    public Node deepCopy(Node head){
        if(head==null){
            return null;
        }
        Node dummy=new Node(-1);
        Node prev=dummy;
        Node curr=head;
        while(curr!=null){
            prev.next=curr.next;
            curr.next=curr.next.next;
            
            curr=curr.next;
            prev=prev.next;
        }
        
        return dummy.next;
    }
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        copylist(head);
        copyRandomPointers(head);
        return deepCopy(head);
    }
}