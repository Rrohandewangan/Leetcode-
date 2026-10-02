class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        helper(ans, new StringBuilder(), 0, 0, n);

        return ans;
    }

    public void helper(List<String> ans, StringBuilder curr, int open, int close, int n) {

        if(curr.length() == 2 * n) {
            ans.add(curr.toString());
            return;
        }

        if(open < n) {
            curr.append('(');

            helper(ans, curr, open + 1, close, n);

            //backtrack
            curr.deleteCharAt(curr.length() - 1);
        }

        if(close < open) {
            curr.append(')');

            helper(ans, curr, open, close + 1, n);

            curr.deleteCharAt(curr.length() - 1);
        }
    }
}