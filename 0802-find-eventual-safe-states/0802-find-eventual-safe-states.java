class Solution {
    // TC -> O(V + E)
    // SC -> O(V)
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> revGraph = new ArrayList<>();
        for(int i=0; i<V; i++) {
            revGraph.add(new ArrayList<>());
        }
        int[] indegree = new int[V];
        for(int i=0; i<V; i++) {
           // i -> it
           // it -> i
            for(int it : graph[i]) {
                revGraph.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0; i<V; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);
            for(int it : revGraph.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) q.offer(it);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}