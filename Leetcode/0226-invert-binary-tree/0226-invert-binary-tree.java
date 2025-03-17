/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//시간복잡도: O(n)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        TreeNode cur = root;
        dfs(cur);

        return root;
    }

    public void dfs(TreeNode cur) {
        if(cur == null) {
            return;
        }

        dfs(cur.left);
        dfs(cur.right);

        TreeNode temp = cur.left;
        cur.left = cur.right;
        cur.right = temp;
    }
}