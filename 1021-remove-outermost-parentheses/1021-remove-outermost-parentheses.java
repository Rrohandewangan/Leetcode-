class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int cnt = -1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                cnt++;
                if (cnt > 0) {
                    sb.append(c);
                }
            } else {
                if (cnt > 0)
                    sb.append(c);
                cnt--;
            }
        }
        return sb.toString();
    }
}