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
    public ListNode swapPairs(ListNode head) {
        ListNode answer = new ListNode(0);
        answer.next = head;

        ListNode cur = answer;
        while(cur.next != null && cur.next.next != null) {
            ListNode front = cur.next;
            ListNode back = cur.next.next;

            ListNode next = cur.next.next.next;

            front.next = next;

            cur.next = back;
            cur.next.next = front;

            cur = cur.next.next;
        }

        return answer.next;
    }
}