class Solution {
    // TC -> O(E x logV)
    // SC -> O(V + E)
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int wt = time[2];

            adj.get(u).add(new int[] { v, wt });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[0], y[0]));

        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int) 1e9);

        dist[k] = 0;
        pq.offer(new int[] { 0, k });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int dis = curr[0];
            int node = curr[1];

            if (dis > dist[node])
                continue;

            for (int[] it : adj.get(node)) {
                int adjNode = it[0];
                int edW = it[1];

                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.offer(new int[] { dist[adjNode], adjNode });
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {

            if (dist[i] == (int) 1e9) {
                return -1;
            }

            max = Math.max(max, dist[i]);
        }

        return max;

    }
}