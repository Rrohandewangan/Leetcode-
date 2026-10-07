class Solution {
    public int helper(int[] nums, int k) {
         if (k < 0)
            return 0;

        int left = 0, right = 0, sum = 0, cnt = 0;

        while (right < nums.length) {

            sum += nums[right] % 2;

            while (sum > k) {
                sum -= nums[left] % 2;
                left++;
            }

            if (sum <= k) {
                cnt += right - left + 1;
            }
            right++;
        }
        return cnt;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        
        int ans = helper(nums, k) - helper(nums, k-1);

        return ans;
    }
}