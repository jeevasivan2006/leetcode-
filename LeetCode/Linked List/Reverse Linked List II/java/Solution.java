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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftpre = dummy;
        ListNode currNode = head;

        // move leftpre to node before left, currNode to node at left
        for (int i = 0; i < left - 1; i++) {
            leftpre = leftpre.next;
            currNode = currNode.next;
        }

        // node where sublist starts
        ListNode subListed = currNode;
        ListNode preNode = null;

        // reverse sublist of length right - left + 1
        for (int i = 0; i <= right - left; i++) {
            ListNode nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }

        // reconnect
        leftpre.next = preNode;
        subListed.next = currNode;

        return dummy.next;
    }
}