class Solution {
    // TC -> O(n * n)
    // SC -> O(1)
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, maxLen = 0, zeros = 0;

        while (r < nums.length) {

            if (nums[r] == 0)
                zeros++;

            if (zeros > k) {
                if (nums[l] == 0)
                    zeros--;
                l++;
            }
            if (zeros <= k) {
                int len = r - l + 1;
                maxLen = Math.max(len, maxLen);
            }
            r++;
        }

        return maxLen;
    }
}