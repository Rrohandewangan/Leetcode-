class Tuple {
    int dist, row, col;
    public Tuple(int distance, int row, int col) {
        this.row = row;
        this.col = col;
        this.dist = distance;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int i=0; i<n; i++) {
            Arrays.fill(dist[i], (int) 1e9);
        }
        dist[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while(!pq.isEmpty()) {
            Tuple it = pq.poll();
            int diff = it.dist;
            int row = it.row;
            int col = it.col;

            if(row == n-1 && col == m - 1) return diff;
            
            for(int i=0; i<4; i++) {
                int nrow = row + dr[i];
                int ncol = col + dc[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                  int newEffort = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]), diff);
                  if(newEffort < dist[nrow][ncol]) {
                    dist[nrow][ncol] = newEffort;
                    pq.add(new Tuple(newEffort, nrow, ncol));
                  }
                }
            }
        }
        return 0;
    }
}