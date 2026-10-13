class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] square = new long[n];

        for(int i=0; i<n; i++) {
            square[i] = 1L * nums[i] * nums[i];
        }

        Arrays.sort(square);

        int subCnt = n / 2;
        long ans = 0;

        for(int i=0; i<n; i++) {
            if(i < subCnt) {
                ans -= square[i];
            } else {
                ans += square[i];
            }
        }
        return ans;
    }
}