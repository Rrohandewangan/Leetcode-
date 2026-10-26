class Solution {
    private long bfs(int row, int col, int[][] vis, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{row, col});
        vis[row][col] = 1;

        long sum = 0;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            sum += grid[r][c];

            for(int i=0; i<4; i++) {
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];

                if(nrow >=0 && nrow < n && ncol >= 0 && ncol < m
                && grid[nrow][ncol] > 0 && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.offer(new int[]{nrow, ncol});
                }
            }
        }

        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        int cnt = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] > 0 && vis[i][j] == 0) {
                    long sum = bfs(i , j, vis, grid);

                    if(sum % k == 0) cnt++;
                }
            }
        }
        return cnt;
    }
}