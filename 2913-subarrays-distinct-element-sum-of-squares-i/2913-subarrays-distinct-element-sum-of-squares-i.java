class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int ans = 0;

        for (int st = 0; st < n; st++) {

            HashSet<Integer> set = new HashSet<>();
            for (int end = st; end < n; end++) {
                set.add(nums.get(end));

                int cnt = set.size();
                ans += cnt * cnt;
            }
        }
        return ans;
    }
}