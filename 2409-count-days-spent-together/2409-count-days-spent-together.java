class Solution {
    private int toDayOfYear(String s) {
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int month = Integer.parseInt(s.substring(0,2));
        int date = Integer.parseInt(s.substring(3, 5));

        int dayOfYear = date;

        for(int i=0; i<month - 1; i++) {
            dayOfYear += monthDays[i];
        }

        return dayOfYear;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arrAlice = toDayOfYear(arriveAlice);
        int leaAlice = toDayOfYear(leaveAlice);
        int arrBob = toDayOfYear(arriveBob);
        int leaBob = toDayOfYear(leaveBob);

        int st = Math.max(arrAlice, arrBob);
        int end = Math.min(leaAlice, leaBob);

        if(st > end) {
            return 0;
        }

        return end - st + 1;
    }
}