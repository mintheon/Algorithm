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
 // 시간복잡도: O(n)
 // 공간복잡도: O(n)
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null) {
            slow = slow.next;
        }

        ListNode node = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = node;
            node = slow;
            slow = next;
        }

        while(node != null) {
            if(node.val != head.val) {
                return false;
            }

            node = node.next;
            head = head.next;
        }

        return true;
    }
}