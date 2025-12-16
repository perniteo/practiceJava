package Programmers.PCCP.퍼즐_게임_챌린지_2번;

public class BF_fail {
  // lv 범위를 적절하게 줄여나갈 생각을 하지 못했음
  // test_case 16 18 시간초과
  // greedy 로 찾아내야 했나? 했지만 일단 구현만 했음
  // 효과적으로 lv 범위를 줄여야 할 것

    public int solution(int[] diffs, int[] times, long limit) {
      int lv = 1;

      while (true) {
        long timeSum = times[0];

        for (int i = 1; i < diffs.length; i++) {
          if (lv >= diffs[i]) {
            timeSum += times[i];
          }
          else {
            timeSum += (long) (times[i - 1] + times[i]) * (diffs[i] - lv) + times[i];
          }
          if (timeSum > limit) {
            lv++;
            break;
          }
        }
        if (timeSum <= limit) {
          break;
        }
      }


      return lv;
    }
  }
