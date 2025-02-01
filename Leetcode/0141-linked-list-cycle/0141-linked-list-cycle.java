/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new LinkedHashSet<>();

        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if(set.contains(cur)) {
                return true;
            }
            
            set.add(cur);
            cur = cur.next;
        }

        return false;
    }
}