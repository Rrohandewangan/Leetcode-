class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> triplet = new ArrayList<>();

        for(int i=0; i<n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for(int j=i+1; j<n; j++) {
                int third = -(nums[i] + nums[j]);

                if(set.contains(third)) {
                  triplet = Arrays.asList(nums[i], nums[j], third);
                  Collections.sort(triplet);
                  ans.add(triplet);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(ans);
    }
}