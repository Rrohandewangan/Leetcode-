class Solution {
    public int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    public int maxLength(int[] nums) {
        int n = nums.length;

        int len = 0;
        for(int i=0; i<n; i++) {
            int prod = 1;
            int gcd = nums[i];
            int lcm = nums[i];
            for(int j=i; j<n; j++) {
                prod *= nums[j];
                gcd = gcd(gcd, nums[j]);
                lcm = lcm(lcm, nums[j]);
                
                if(prod == gcd * lcm) len = Math.max(len, j-i+1);
            }
        }
        return len;
    }
}