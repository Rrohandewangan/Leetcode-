class Solution {
    public boolean canAliceWin(int n) {
        int stoneRemoved = 10;
        boolean aliceT = true;

        while(n >= stoneRemoved) {
            n = n - stoneRemoved;
            stoneRemoved--;

            aliceT = !aliceT;
        }

        return !aliceT;
    }
}