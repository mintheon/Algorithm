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
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();

        ListNode cur = head;
        while(cur != null) {
            deque.addFirst(cur.val);
            cur = cur.next;
        }

        while(!deque.isEmpty()) {
            if(deque.size() == 1) {
                return true;
            }

            if(deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }

        return true;
    }
}