class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            boolean isEligible = true;
            
            int hour = schedules[i] / 100;
            int minute = schedules[i] % 100 + 10;
            if (minute >= 60) {
                hour++;
                minute -= 60;
            }
            int limitTime = hour * 100 + minute;

            for (int j = 0; j < 7; j++) {
                int currentDay = (startday + j - 1) % 7 + 1;
                if (currentDay == 6 || currentDay == 7) {
                    continue;
                }

                if (timelogs[i][j] > limitTime) {
                    isEligible = false;
                    break;
                }
            }

            if (isEligible) {
                answer++;
            }
        }
        return answer;
    }
}