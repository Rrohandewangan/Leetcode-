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
public class BSTIterator {
    private Stack<TreeNode> st = new Stack<>();
    // reverse -> true -> before
    // reverse -> false -> next
    boolean reverse = true;

    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }

    // return whether we have next smallest number //
    public boolean hasNext() {
        return !st.isEmpty();
    }

    // return the next smallest number//
    public int next() {
        TreeNode tmpNode = st.pop();
        if(reverse == false) pushAll(tmpNode.right);
        else pushAll(tmpNode.left);
        return tmpNode.val;
    }

    private void pushAll(TreeNode node) {
        while(node != null) {
            st.push(node);
            if(reverse == true) {
              node = node.right;
            } else {
              node = node.left;
            }
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        int i = left.next(); // next
        int j = right.next(); // before
        while(i < j) {
            if(i + j == k) return true;
            else if(i + j < k) i = left.next();
            else j = right.next();
        }
        return false;
    }
}