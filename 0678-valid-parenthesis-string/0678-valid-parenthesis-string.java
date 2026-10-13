class Solution {
    // TC -> O(n)
    // SC -> O(1)
    public boolean checkValidString(String s) {
        int n = s.length();
        int min = 0, max = 0;
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);

            if(c == '(') {
                min = min + 1;
                max = max + 1;
            }
            else if(c == ')') {
                min = min - 1;
                max = max - 1;
            }
            else  {
                min = min - 1;
                max = max + 1;
            }

            if(min < 0) min = 0;
            if(max < 0) return false;
        }
        return min == 0;
    }
}