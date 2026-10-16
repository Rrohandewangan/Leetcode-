class Solution {
    private static final long MOD = 1_000_000_007L;

    private long[] tree;
    private long[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;

        tree = new long[4 * n];
        lazy = new long[4 * n];

        Map<Integer, Integer> lastSeen = new HashMap<>();

        long endingSum = 0;
        long answer = 0;

        for (int end = 0; end < n; end++) {
            int prev = lastSeen.getOrDefault(nums[end], -1);

            int left = prev + 1;
            int right = end;

            // Counts before adding the current element.
            long oldCountSum = query(
                1, 0, n - 1, left, right
            );

            long length = right - left + 1;

            // Update the sum of squared distinct counts
            // for all subarrays ending at 'end'.
            endingSum = (
                endingSum + 2 * oldCountSum + length
            ) % MOD;

            // These subarrays gain one distinct element.
            update(1, 0, n - 1, left, right);

            answer = (answer + endingSum) % MOD;

            lastSeen.put(nums[end], end);
        }

        return (int) answer;
    }

    private void apply(int node, int start, int end, long value) {
        tree[node] += (end - start + 1L) * value;
        lazy[node] += value;
    }

    private void push(int node, int start, int end) {
        if (lazy[node] == 0 || start == end) {
            return;
        }

        int mid = start + (end - start) / 2;

        apply(node * 2, start, mid, lazy[node]);
        apply(node * 2 + 1, mid + 1, end, lazy[node]);

        lazy[node] = 0;
    }

    private void update(
        int node, int start, int end, int left, int right
    ) {
        // No overlap.
        if (right < start || end < left) {
            return;
        }

        // Complete overlap.
        if (left <= start && end <= right) {
            apply(node, start, end, 1);
            return;
        }

        push(node, start, end);

        int mid = start + (end - start) / 2;

        update(node * 2, start, mid, left, right);
        update(node * 2 + 1, mid + 1, end, left, right);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private long query(
        int node, int start, int end, int left, int right
    ) {
        // No overlap.
        if (right < start || end < left) {
            return 0;
        }

        // Complete overlap.
        if (left <= start && end <= right) {
            return tree[node];
        }

        push(node, start, end);

        int mid = start + (end - start) / 2;

        return query(node * 2, start, mid, left, right)
             + query(node * 2 + 1, mid + 1, end, left, right);
    }
}
