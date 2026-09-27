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
    public ListNode reverse(ListNode l1){
        ListNode prev=null;
        ListNode curr=l1;
         ListNode after=null;
         while(curr!=null){
            after=curr.next;
            curr.next=prev;
             prev=curr;
            curr=after;
           
         }
         return prev;

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newl1= reverse(l1);
         ListNode newl2= reverse(l2);
         ListNode dummy=new ListNode(1);
         ListNode temp=dummy;
         ListNode temp1=newl1;
         ListNode temp2=newl2;
         int carry=0;
         while(temp1!=null || temp2!=null || carry!=0){
             int x=(temp1!=null)?temp1.val:0;
             int y=(temp2!=null)?temp2.val:0;
             int sum=x+y+carry;
             carry=sum/10;
            ListNode a=new ListNode(sum%10);
            temp.next=a;
            temp=temp.next;
            if(temp1!=null)temp1=temp1.next;
            
            if(temp2!=null) temp2=temp2.next;
         }
         return reverse(dummy.next);      
    }
}