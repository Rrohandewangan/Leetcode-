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
    public int findMaxDistance(Map<TreeNode, TreeNode> Parent_tracker, TreeNode target) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        Map<TreeNode, Integer> vis = new HashMap<>();
        vis.put(target, 1);
        int max = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            int fl = 0;

            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if(node.left != null && vis.get(node.left) == null) {
                    fl = 1;
                    vis.put(node.left, 1);
                    q.offer(node.left);
                }
                if(node.right != null && vis.get(node.right) == null) {
                    fl = 1;
                    vis.put(node.right, 1);
                    q.offer(node.right);
                }
                if(Parent_tracker.get(node) != null && vis.get(Parent_tracker.get(node)) == null) {
                    fl = 1;
                    vis.put(Parent_tracker.get(node), 1);
                    q.offer(Parent_tracker.get(node));
                }
            }
            if(fl == 1) max++;
        }
        return max;
    }
    public TreeNode bfsToMapParents(TreeNode root, Map<TreeNode, TreeNode> Parent_tracker, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode res = new TreeNode(-1);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.val == start) res = node;
            if(node.left != null) {
               Parent_tracker.put(node.left, node);
               q.offer(node.left);
            }
            if(node.right != null) {
               Parent_tracker.put(node.right, node);
               q.offer(node.right);
            }
        }
        return res;
    }
    public int amountOfTime(TreeNode root, int start) {
         Map<TreeNode, TreeNode> Parent_tracker = new HashMap<>();
         TreeNode target = bfsToMapParents(root, Parent_tracker, start);
         int maxi = findMaxDistance(Parent_tracker, target);
         return maxi;
    }
}