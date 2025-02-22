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
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int depth = 0;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(1);

        while(!nodeStack.isEmpty()) {
            TreeNode current = nodeStack.pop();
            int currentDepth = depthStack.pop();

            depth = Math.max(depth, currentDepth);
            
            if(current.left != null) {
                nodeStack.push(current.left);
                depthStack.push(currentDepth + 1);
            }

            if(current.right != null) {
                nodeStack.push(current.right);
                depthStack.push(currentDepth + 1);
            }
        }

        return depth;
    }
}