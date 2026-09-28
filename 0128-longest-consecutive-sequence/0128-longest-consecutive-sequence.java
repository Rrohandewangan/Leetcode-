class Solution {
    // TC -> O(nlogn)
    // Sc
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int longest = 0, currCnt = 0, lastSmallest = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 == lastSmallest) {
                currCnt += 1;
                lastSmallest = nums[i];
            } else if (nums[i] != lastSmallest) {
                currCnt = 1;
                lastSmallest = nums[i];
            }
            longest = Math.max(longest, currCnt);
        }
        return longest;
    }
}