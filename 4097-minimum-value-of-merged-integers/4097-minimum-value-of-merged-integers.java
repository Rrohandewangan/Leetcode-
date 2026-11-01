class Solution {
    public int minMergedInteger(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;

        for(int i=0; i < n-1; i+=2) {
            StringBuilder sb = new StringBuilder();
            int first = nums[i];
            int second = nums[i + 1];

            sb.append(first).append(second); 
            int num = Integer.parseInt(sb.toString());

            min = Math.min(min, num);
        }
        return min;
    }
}