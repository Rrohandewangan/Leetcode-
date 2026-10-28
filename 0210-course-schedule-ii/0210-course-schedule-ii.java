class Solution {
    // TC -> O(V + E)
    // SC -> O(V)
    public int[] findOrder(int V, int[][] prerequisites) {
        // for a graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        int[] topo = new int[V];
        int idx = 0;
        // O(V + E)
        while (!q.isEmpty()) {
            int node = q.poll();
            topo[idx++] = node;

            // node is in your topo sort 
            // so please remove it from the indegree
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.offer(it);
            }
        }

        if (idx == V) return topo;
        return new int[0];
    }
}