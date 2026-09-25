class Solution {
    public int findMin(int[] nums) {
        int st = 0, end = nums.length-1, min = Integer.MAX_VALUE;
        while(st <= end) {
            int mid = st + (end - st)/2;

            if(nums[st] <= nums[mid]) {
                min = Math.min(min, nums[st]);
                st = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                end = mid - 1;
            }
        }
        return min;
    }
}