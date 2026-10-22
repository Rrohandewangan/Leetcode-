class Solution {
    private boolean dfs(int node, int currCol, int[] color,
    int[][] graph) {
        color[node] = currCol;

        for(int it : graph[node]) {
            if(color[it] == -1) {
                if(dfs(it, 1 - currCol, color, graph) == false) return false;
            }
            else if(color[it] == currCol) {
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i=0; i<n; i++) {
          if(color[i] == -1) {
            if(dfs(i, 0, color, graph) == false) return false;
           }
        }
      return true;
    }
}