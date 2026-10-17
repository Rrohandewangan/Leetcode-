class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        // to store each row with {number, digit sum}
        int[][] sorted = new int[n][2];

        // To store number with it curr index
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            sorted[i][0] = nums[i];
            sorted[i][1] = digitSum(nums[i]);

            map.put(nums[i], i);
        }

        Arrays.sort(sorted, (a, b) -> {
            
            if(a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        int swaps = 0;

        for(int i=0; i<n; i++) {
            int req = sorted[i][0];

            if(nums[i] == req) {
                continue;
            }

            int j = map.get(req);
            int displaced = nums[i];

            nums[i] = req;
            nums[j] = displaced;

            map.put(req, i);
            map.put(displaced, j);

            swaps++;
        }

        return swaps++;
    }

    private int digitSum(int num) {
        int sum = 0;

        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}