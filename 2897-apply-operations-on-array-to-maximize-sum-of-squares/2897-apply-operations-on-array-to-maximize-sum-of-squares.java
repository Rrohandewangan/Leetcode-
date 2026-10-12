class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long MOD = 1_000_000_007L;

        int[] cnt = new int[31];
 
        // count set bits
        for(int num : nums) {
            for(int bit=0; bit<31; bit++) {
                if((num & (1 << bit)) != 0) {
                    cnt[bit]++;
                }
            }
        }

        long ans = 0;

        // construct k numbers
        for(int i=0; i<k; i++) {
            long num = 0;

            for(int bit=0; bit<31; bit++) {
                if(cnt[bit] > 0) {
                    num |= (1L << bit);
                    cnt[bit]--;
                }
            }

            ans = (ans + num * num) % MOD;
        }
        
        return (int) ans;
    }
}