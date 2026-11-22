class DisjointSet {
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for(int i=0; i<n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findPar(int node) {
        if(node == parent.get(node)) {
            return node;
        }

        int ulp = findPar(parent.get(node));
        parent.set(node, ulp);

        return ulp;
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findPar(u);
        int ulp_v = findPar(v);
        if(ulp_u == ulp_v) return;
        
        if(size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
        else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n);
        int cntExtras = 0;
        int m = edges.length;
        for(int i=0; i<m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if(ds.findPar(u) == ds.findPar(v)) {
                cntExtras++;
            } else {
                ds.unionBySize(u, v);
            }
        }

        int cntCom = 0;
        for(int i=0; i<n; i++) {
            if(ds.parent.get(i) == i) cntCom++;
        }
        int ans = cntCom - 1;
        if(cntExtras >= ans) return ans;
        return -1;
    }
}