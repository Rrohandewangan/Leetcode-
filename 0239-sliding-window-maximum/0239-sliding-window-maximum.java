class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0;

        for(int right = 0; right < n; right++) {
           
           // remove indices outside current window
            while(!dq.isEmpty() && dq.peekFirst() < right - k + 1) {
                dq.pollFirst();
            }

            // Remove smaller elements
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[right]) {
                dq.pollLast();
            }
           
            // add current index
            dq.offerLast(right);

            // winodw of size k is formed
            if(right >= k - 1) {
                ans[idx++] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}