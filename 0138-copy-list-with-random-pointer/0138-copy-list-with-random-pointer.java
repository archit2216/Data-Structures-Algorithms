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
    public Node deepCopy(Node head){
        Node dummy=new Node(-1);
        Node temp=dummy;
        
        Node curr=head;
        while(curr!=null){
            temp.next=curr.next;
            curr.next=curr.next.next;
            curr=curr.next;
            
            temp=temp.next;
        }
        
        return dummy.next;
    }
    public void copyRandom(Node head){
        Node curr=head;
        while(curr!=null){
            Node Random=curr.random;
            if(Random!=null){
                curr.next.random=Random.next;
            }
            curr=curr.next.next;
        }
    }
    public void copyList(Node head){
        Node curr=head;
        
        while(curr!=null){
            Node newNode=new Node(curr.val);
            newNode.next=curr.next;
            curr.next=newNode;
            curr=curr.next.next;
        }
    }
    public Node copyRandomList(Node head) {
        copyList(head);
        copyRandom(head);
        return deepCopy(head);
    }
}