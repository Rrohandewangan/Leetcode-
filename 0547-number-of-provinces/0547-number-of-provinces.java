class Solution {
    // TC -> O(n) + O(n + 2V)
    // SC -> O(n) + O(n)
    private void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;

        for(int it : adj.get(node)) {
            if(!vis[it]) {
                dfs(it, vis, adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<V; i++) {
           for(int j=0; j<V; j++) {
              if(isConnected[i][j] == 1 && i != j) {
                adj.get(i).add(j);
              }
           }
        }
        boolean[] vis = new boolean[V];
        int cnt = 0;

        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                cnt++;
                dfs(i, vis, adj);
            }
        }
        return cnt;
    }
}