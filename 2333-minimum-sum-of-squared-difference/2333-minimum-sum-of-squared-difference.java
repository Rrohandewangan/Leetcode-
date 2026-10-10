
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int n = nums1.length;
        int[] diff = new int[n];

        long k = (long) k1 + k2;
        long total = 0;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);

            total += diff[i];
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        if (total <= k) return 0;

        int low = 0, high = maxDiff;

        // Find the minimum achievable maximum difference
        while (low < high) {

            int mid = low + (high - low) / 2;
            long operations = 0;

            for (int d : diff) {
                if (d > mid) {
                    operations += d - mid;
                }
            }

            if (operations <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int level = low;

        // Spend operations to reduce differences to level
        for (int d : diff) {
            if (d > level) {
                k -= d - level;
            }
        }

        long ans = 0;

        for (int d : diff) {

            long current = Math.min(d, level);

            if (current == level && k > 0) {
                current--;
                k--;
            }

            ans += current * current;
        }

        return ans;
    }
}
