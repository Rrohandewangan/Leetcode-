class Solution {
    // TC -> O()
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for(int k=1; k<=n; k++) {
            if(n % k != 0) {
                continue;
            }

            boolean valid = true;
            int prevMax = Integer.MIN_VALUE;

            for(int st = 0; st < n; st += k) {
                int end = st + k - 1;

                int drop = 0;
                int mini = Integer.MAX_VALUE;
                int maxi = Integer.MIN_VALUE;

                for(int i=st; i<=end; i++) {
                    mini = Math.min(mini, nums[i]);
                    maxi = Math.max(maxi, nums[i]);

                    if(i < end && nums[i] > nums[i+1]) {
                        drop++;
                    }
                }

                if(nums[end] > nums[st]) drop++;

                if(drop > 1 || prevMax > mini) {
                    valid = false;
                    break;
                }
                prevMax = maxi;
            }
             
            if(valid) {
                ans += k;
            }
        }
        return ans;
    }
}