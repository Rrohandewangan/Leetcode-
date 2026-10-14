class Solution {
    // TC -> O(n)
    // SC -> O(1)
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0, left = 0, right = 0;

        while(right < n - 1) {
            int farthest  = 0;
            for(int i = left; i <= right; i++) {
                farthest = Math.max(i + nums[i], farthest);
            }
            jumps++;
            left = right + 1;
            right = farthest;
        }
        return jumps;
    }
}