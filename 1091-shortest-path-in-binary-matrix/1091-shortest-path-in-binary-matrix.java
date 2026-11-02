class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }

        if (n == 1 && m == 1) {
            return 1;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        vis[0][0] = true;
        q.add(new int[]{1, 0, 0});

        while (!q.isEmpty()) {

            int[] it = q.poll();

            int dis = it[0];
            int r = it[1];
            int c = it[2];

            for (int i = 0; i < 8; i++) {

                int nrow = r + dr[i];
                int ncol = c + dc[i];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    grid[nrow][ncol] == 0 &&
                    !vis[nrow][ncol]) {

                    if (nrow == n - 1 && ncol == m - 1) {
                        return dis + 1;
                    }

                    vis[nrow][ncol] = true;
                    q.add(new int[]{dis + 1, nrow, ncol});
                }
            }
        }

        return -1;
    }
}