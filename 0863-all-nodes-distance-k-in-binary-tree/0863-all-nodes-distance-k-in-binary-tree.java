/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void marksParents(TreeNode root, Map<TreeNode, TreeNode> parent_track, TreeNode traget) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr.left != null) {
               parent_track.put(curr.left, curr);
               q.offer(curr.left);
            }
            if(curr.right != null) {
               parent_track.put(curr.right, curr);
               q.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        marksParents(root, parent_track, root);

        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(target);
        visited.put(target, true);
        int dis = 0;
        while(!q.isEmpty()) { // Second BFS to go upto k dis from target node and using our hashmap info.//
        int size = q.size();
        if(dis == k) break;
        dis++;
        for(int i=0; i<size; i++) {
            TreeNode curr = q.poll();
            if(curr.left != null && visited.get(curr.left) == null) {
                q.offer(curr.left);
                visited.put(curr.left, true);
            }
            if(curr.right != null && visited.get(curr.right) == null) {
                q.offer(curr.right);
                visited.put(curr.right, true);
            }
            if(parent_track.get(curr) != null && visited.get(parent_track.get(curr)) == null) {
                q.offer(parent_track.get(curr));
                visited.put(parent_track.get(curr), true);
            }
        }
    }
    List<Integer> ans = new ArrayList<>();
    while(!q.isEmpty()) {
        TreeNode curr = q.poll();
        ans.add(curr.val);
    }
    return ans;
  }
}