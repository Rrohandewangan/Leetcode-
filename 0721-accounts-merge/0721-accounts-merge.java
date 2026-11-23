class DisjointSet {
    ArrayList<Integer> parent  = new ArrayList<>();
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
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
        else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> details) {
        int n = details.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mapMailNode = new HashMap<>();

        for(int i=0; i<n; i++) {
            for(int j=1; j<details.get(i).size(); j++) {
                String mail = details.get(i).get(j);
                if(mapMailNode.containsKey(mail) == false) {
                    mapMailNode.put(mail, i);
                }
                else {
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }

        ArrayList<String>[] mergeMail = new ArrayList[n];
        for(int i=0; i<n; i++) {
            mergeMail[i] = new ArrayList<String>();
        }

        for(Map.Entry<String, Integer> it : mapMailNode.entrySet()) {
            String mail = it.getKey();
            int node = ds.findPar(it.getValue());
            mergeMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(mergeMail[i].size() == 0) continue;
            Collections.sort(mergeMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(details.get(i).get(0));
            for(String it : mergeMail[i]) {
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
} 