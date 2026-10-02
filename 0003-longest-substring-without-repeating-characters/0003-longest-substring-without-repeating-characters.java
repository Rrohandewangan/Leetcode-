class Solution {
    // TC -> O(n)
    // SC -> O(n)
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        
        int left = 0;
        int maxLen = 0;

        for(int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);

            if(lastSeen.containsKey(curr) && lastSeen.get(curr) >= left) {
                left = lastSeen.get(curr) + 1;
            }

            lastSeen.put(curr, right);

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}