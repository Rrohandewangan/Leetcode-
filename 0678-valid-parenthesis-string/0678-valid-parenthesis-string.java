class Solution {
    public boolean checkValidString(String s) {
       int cnt = 0;

       for(char c : s.toCharArray()) {
        if(c == '(' || c == '*') cnt++;
        else cnt--;

        if(cnt < 0) return false;
       }
       cnt = 0;

       for(int i=s.length() - 1; i >=0; i--) {
        if(s.charAt(i) == ')' || s.charAt(i) == '*') cnt++;
        else cnt--;

        if(cnt < 0) return false;
       }
       return true;
    }
}