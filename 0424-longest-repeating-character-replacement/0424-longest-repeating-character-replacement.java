class Solution {
    // TC -> O(n)
    // SC -> O(1)
    public int characterReplacement(String s, int k) {
        int n = s.length();

        if (n == 0 || k < 0)
            return 0;

        int[] freq = new int[26];

        int left = 0, maxFreq = 0, maxLen = 0;

        for (int right = 0; right < n; right++) {
            int idx = s.charAt(right) - 'A';
            freq[idx]++;

            maxFreq = Math.max(maxFreq, freq[idx]);

            int currLen = right - left + 1;

            if (currLen - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            
            currLen = right - left + 1;

            maxLen = Math.max(currLen, maxLen);

        }
        return maxLen;
    }
}