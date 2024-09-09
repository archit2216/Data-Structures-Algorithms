/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] arr=new int[m][n];
        int rs=0;
        int cs=0;
        int re=m-1;
        int ce=n-1;
        ListNode temp=head;
        int count=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=-1;
            }
        }
        while(count<=m*n){
            for(int i=cs;i<=ce;i++){
                arr[rs][i]=temp==null?-1:temp.val;
                if(temp!=null){
                    temp=temp.next;
                }
                if(count>m*n){
                    break;
                }else{
                    count++;
                }
            }
            if(count>m*n){
                    break;
                }
            rs++;
            for(int i=rs;i<=re;i++){
                arr[i][ce]=temp==null?-1:temp.val;
                if(temp!=null){
                    temp=temp.next;
                }
                if(count>m*n){
                    break;
                }else{
                    count++;
                }
            }
            if(count>m*n){
                    break;
                }
            ce--;
            for(int i=ce;i>=cs;i--){
                arr[re][i]=temp==null?-1:temp.val;
                if(temp!=null){
                    temp=temp.next;
                }
                if(count>m*n){
                    break;
                }else{
                    count++;
                }
            }
            if(count>m*n){
                    break;
                }
            re--;
            for(int i=re;i>=rs;i--){
                arr[i][cs]=temp==null?-1:temp.val;
                if(temp!=null){
                    temp=temp.next;
                }
                if(count>m*n){
                    break;
                }else{
                    count++;
                }
            }
            if(count>m*n){
                    break;
                }
            cs++;
        }
        return arr;
    }
}