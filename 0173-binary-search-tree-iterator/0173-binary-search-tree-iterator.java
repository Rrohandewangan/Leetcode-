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
class BSTIterator {
    private Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    // return the next smallest number // 
    public int next() {
        TreeNode tempNode = st.pop();
        pushAll(tempNode.right);
        return tempNode.val;
    }
    
    // return whether we have a next smallest number //
    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void pushAll(TreeNode node) {
        for(; node != null; st.push(node), node = node.left);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */