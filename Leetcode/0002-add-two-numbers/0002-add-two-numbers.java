/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 //시간 복잡도 O(n)
 //공간 복잡도 O(n)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode answer = new ListNode(0);
        int plus = 0;

        ListNode cur = answer;
        while(l1 != null || l2 != null || plus != 0) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;

            int sum = num1 + num2 + plus;
            plus = sum / 10;

            cur.next = new ListNode(sum % 10);

            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;

            cur = cur.next;
        }

        return answer.next;
    }
}