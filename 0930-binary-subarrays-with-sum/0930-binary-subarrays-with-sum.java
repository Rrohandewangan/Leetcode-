class Solution {
    // TC -> O(2 * 2n)
    // SC -> O(1)
    public int helper(int[] nums, int goal) {
        int n = nums.length;
        if(goal < 0) {
            return 0;
        }

        int left = 0, right = 0, sum = 0, cnt = 0;

        while(right < n) { // O(n)
            sum += nums[right];

            while(sum > goal) {  //overall O(n)
                sum -= nums[left];
                left++;
            }
            cnt += right - left + 1;
            right++;
        }
        return cnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = helper(nums, goal) - helper(nums, goal-1);
        return ans;
    }
}