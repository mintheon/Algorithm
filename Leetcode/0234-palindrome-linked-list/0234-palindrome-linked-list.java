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
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode node = null;
        while(slow != null) {
            ListNode temp = slow.next;
            slow.next = node;
            node = slow;
            slow = temp;
        }

        while(node != null) {
            if(head.val != node.val) {
                return false;
            }
            head = head.next;
            node = node.next;
        }

        return true;
    }
}