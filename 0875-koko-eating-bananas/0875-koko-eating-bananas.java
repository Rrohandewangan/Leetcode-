class Solution {
    public int maxPossibleK(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        return max;
    }

    public boolean isPossible(int[] piles, int h, int minTime) {
        long totalTime = 0;
        for (int i = 0; i < piles.length; i++) {
            int reqTime = (int) Math.ceil((double) piles[i] / minTime);
            totalTime += reqTime;
        }
        return totalTime <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = maxPossibleK(piles);

        int st = 1, end = max;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (isPossible(piles, h, mid)) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }
}