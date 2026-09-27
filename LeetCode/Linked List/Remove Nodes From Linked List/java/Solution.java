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
    public ListNode removeNodes(ListNode head) {
       head=reverse(head);//8 3 13 2 5
       int max=head.val;
       ListNode curr=head;
       while(curr!=null&&curr.next!=null){
        if(curr.next.val<max){//3<8
             curr.next=curr.next.next;
       }
       else{
        curr=curr.next;
        max=curr.val;
       }
        }
        return reverse(head);
    }
   
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}