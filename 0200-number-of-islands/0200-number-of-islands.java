
// TC - O(n2)
// SC -> O(n2)
class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first  = first;
        this.second = second;
    }
}
class Solution {
    private void bfs(int ro, int co, int[][] vis, char[][] grid) {
      vis[ro][co] = 1;
      Queue<Pair> q = new LinkedList<Pair>();
      q.add(new Pair(ro, co));
      int n = grid.length;
      int m = grid[0].length;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

      while(!q.isEmpty()) {
       Pair cell = q.poll();
            int row = cell.first;
            int col = cell.second;

            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;
        for(int row=0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(vis[row][col] == 0 && grid[row][col] == '1') {
                    cnt++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return cnt;
    }
}