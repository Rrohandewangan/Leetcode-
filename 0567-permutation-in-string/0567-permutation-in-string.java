class Solution {
    // TC -> O(n2)
    boolean isFreqSame(int[] freq1, int[] freq2) { //O(1)
        for(int i=0; i<26; i++) {
            if(freq1[i] != freq2[i]) {
                return false ;
            }
        }
        return true ;
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26] ;
        for(int i=0; i<s1.length(); i++) {
        // internally convert into ascii value and give integer type index of character.
        // a -> 0, b -> 1
            freq[s1.charAt(i) - 'a']++ ;
        }

        int windSize = s1.length() ;

        for(int i=0; i<s2.length(); i++) {  //O(n2)
            int windIdx = 0, idx = i ;
            int[] windFreq = new int[26] ;

        while(windIdx < windSize && idx < s2.length()) { // this is check windidx is not exceed windsize and idx is not exceed the length of s2 string .
                windFreq[s2.charAt(idx) - 'a']++ ; // it store the freq of character of s2 string in window freq array 
                windIdx++; idx++ ;
            }

            if(isFreqSame(freq, windFreq)) { // permutation found
                 return true ;
            }
        }

        return false ;
    }
}