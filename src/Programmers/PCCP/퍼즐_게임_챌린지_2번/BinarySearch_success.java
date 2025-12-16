package Programmers.PCCP.퍼즐_게임_챌린지_2번;

public class BinarySearch_success {

  // lv 탐색 범위를 이분하여 최적해를 찾아냄

    public int solution(int[] diffs, int[] times, long limit) {
      int answer = 0;

      int left = 1;
      int right = 0;

      for (int d : diffs) {
        right = Math.max(d, right);
      }


      while (left <= right) {
        int lv = (right + left) / 2;

        long timeSum = times[0];

        for (int i = 1; i < diffs.length; i++) {
          if (lv >= diffs[i]) {
            timeSum += times[i];
          }
          else {
            timeSum += (long) (times[i - 1] + times[i]) * (diffs[i] - lv) + times[i];
          }
          if (timeSum > limit) {
            break;
          }
        }

        if (timeSum <= limit) {
          right = lv - 1;
          answer = lv;
        } else {
          left = lv + 1;
        }
      }


      return answer;
    }
  }
