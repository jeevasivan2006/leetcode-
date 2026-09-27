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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a, ListNode b) -> a.val - b.val);
        for(ListNode list : lists){
            if(list != null){
                pq.offer(list);
            }
        }

        ListNode head = null;
        ListNode tail = null;

        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            if(head == null){
                head = curr;
                tail = head;
            }else {
                tail.next = curr;
                tail = tail.next;
            }
            if(curr.next != null){
                pq.offer(curr.next);
            }
        }

        return head;
    }
}