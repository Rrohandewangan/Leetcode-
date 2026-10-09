class Solution {
    public int minInsertions(String s) {
        int insert = 0, need = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                if (need % 2 == 1) {
                    insert++;
                    need--;
                }
                need += 2;
            } else {
                need--;
                if (need == -1) {
                    insert++;
                    need = 1;
                }
            }
        }
        return insert + need;
    }
}