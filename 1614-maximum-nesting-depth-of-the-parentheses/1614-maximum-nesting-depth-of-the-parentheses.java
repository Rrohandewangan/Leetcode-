class Solution {
    public int maxDepth(String s) {
        
        int n = s.length();
        int maxDepth = 0, depth = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            } else if(c == ')') depth--;
            else continue;

        }
        return maxDepth;
    }
}