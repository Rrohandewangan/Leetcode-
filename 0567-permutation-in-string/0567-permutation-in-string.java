class Solution {
    public boolean isFreqSame(int[] freq1, int[] freq2) {
        for(int i=0; i<freq1.length; i++) {
            if(freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
      
       if(s1.length() > s2.length()) return false;

       int[] freq = new int[26];
       for(int i=0; i<s1.length(); i++) {
          freq[s1.charAt(i) - 'a']++;
       }
       
       int windowSize = s1.length();
       for(int i=0; i<=s2.length() - windowSize; i++) {

          int[] windowFreq = new int[26];
          int windowIdx = 0, idx = i;

          while(windowIdx < windowSize) {
            windowFreq[s2.charAt(idx) - 'a']++;
            windowIdx++; idx++;
          }

          if(isFreqSame(freq, windowFreq)) {
            return true;
          }
       }
       return false;
    }
}