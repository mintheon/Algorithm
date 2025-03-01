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
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        
        while(cur != null) {
            ListNode next = cur.next; //3 4 5
            cur.next = prev;// 2 1 null
            prev = cur; // 2 1 null
            cur = next; // 3 4 5
        }

        return prev;
    }
}