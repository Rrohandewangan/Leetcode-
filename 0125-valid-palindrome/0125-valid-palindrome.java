class Solution {
    private boolean isAlphaNum(char c) {
            return Character.isLetterOrDigit(c);
    }
    public boolean isPalindrome(String s) {
        char[] charArr = s.toCharArray();
        int st = 0, end = s.length()-1;
        while(st <= end) {
           if(!isAlphaNum(s.charAt(st))) {
             st++; continue;
           }
           if(!isAlphaNum(s.charAt(end))) {
             end--; continue;
           }
           if(Character.toLowerCase(s.charAt(st)) != Character.toLowerCase(s.charAt(end))) {
            return false;
           }
           st++;
           end--;
        }
        return true;
    }
}