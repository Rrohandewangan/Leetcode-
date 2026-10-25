class Solution {
    private void dfs(int row, int col, int[][] vis, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = 1;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for(int i=0; i<4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
            && grid[nrow][ncol] == 0 && vis[nrow][ncol] == 0) {
                dfs(nrow, ncol, vis, grid);
            }
        }
    }
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                boolean isBoundary = i == 0 || j == 0 || i == n - 1 || j == m - 1;

                if(isBoundary && grid[i][j] == 0 && vis[i][j] == 0) {
                    dfs(i, j, vis, grid);
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 0 && vis[i][j] == 0) {
                    cnt++;
                    dfs(i, j, vis, grid);
                }
            }
        }
        return cnt;
    }
}