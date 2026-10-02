class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int longest = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums) {
            set.add(val);
        }

        for(int num : set) {

            if(!set.contains(num - 1)) {
                int cnt = 1;
                int x = num;

                while(set.contains(x + 1)) {
                     x += 1;
                    cnt += 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
}