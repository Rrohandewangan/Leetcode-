class Solution {
    public int helper(int[] nums, int k) {
         if (k < 0)
            return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, cnt = 0;

        while (right < nums.length) {

            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {

                int num = nums[left];

                map.put(num, map.get(num) - 1);

                if (map.get(num) == 0)
                    map.remove(num);
                left++;
            }

            cnt += right - left + 1;
            right++;
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {

       int ans = helper(nums, k) - helper(nums, k-1);

       return ans;
    }
}