class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += nums[i];
        }

        return nums[n-1] * n - sum;
    }
}