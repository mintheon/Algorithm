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
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(ListNode listNode : lists) {
            while(listNode != null) {
                queue.add(listNode.val);
                listNode = listNode.next;
            }
        }
        
        System.out.println(queue);

        ListNode answer = new ListNode(0);
        ListNode cur = answer;
        while(!queue.isEmpty()) {
            cur.next = new ListNode(queue.poll());
            cur = cur.next;
        }

        return answer.next;
    }
}