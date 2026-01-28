package Programmers.코드챌린지_2025;

class 유연근무제_1차예선 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < schedules.length; i++) {
            int day = startday;
            int cur = schedules[i];
            int m = cur % 100 + 10;
            int timeout = cur / 100 * 100 + m / 60 * 100 + m % 60;
            boolean event = true;
            for (int j = 0; j < 7; j++) {
                day %= 7;
                if (day == 0 || day == 6) {
                    day++;
                    continue;
                }
                if (timelogs[i][j] > timeout) {
                    event = false;
                    break;
                }
                day++;
            }
          if (event) {
            answer++;
          }
        }
        
        return answer;
    }
}