class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lSum = 0, rSum = 0, maxSum = 0;

        // take all k from front
        for (int i = 0; i < k; i++) {
            lSum = lSum + cardPoints[i];
        }
        maxSum = lSum;
        // take first k - 1 element and take one element from last
        int rightIdx = cardPoints.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            lSum = lSum - cardPoints[i];
            rSum = rSum + cardPoints[rightIdx];
            rightIdx = rightIdx - 1;

            maxSum = Math.max(maxSum, lSum + rSum);
        }

        return maxSum;
    }
}