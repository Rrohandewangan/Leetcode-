class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = logs.length;
        int q = queries.length;

        int[] ans = new int[q];

        Arrays.sort(logs, (a,b) -> Integer.compare(a[1], b[1]));

        int[][] sortedQueries = new int[q][2];

        for(int i=0; i<q; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        int[] cnt = new int[n+1];

        int activeServers = 0;

        int left = 0, right = 0;

        for(int[] it : sortedQueries) {

            int end = it[0];
            int st = end - x;
            int originalIdx = it[1];

            while(right < m && logs[right][1] <= end) {

                int server = logs[right][0];

                if(cnt[server] == 0) activeServers++;

                cnt[server]++;
                right++;
            }

            while(left < right && logs[left][1] < st) {

                int server = logs[left][0];

                cnt[server]--;

                if(cnt[server] == 0) activeServers--;

                left++;
            }

            ans[originalIdx] = n - activeServers;
        }
        return ans;
    }
}