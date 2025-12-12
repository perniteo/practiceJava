package Programmers.PCCE;

public class 공원_10번 {

  // brute-force
  // 간단한 브루트포스 구현이라고 생각했으나
  // mats 배열이 당연히 오름차순 이라고 생각하고 바로 return 하는 방식을 했었음
  // 저 부분에서 디버깅하는데 시간을 많이 잡아 먹음
  // 문제 조건을 잘 파악할 것
  
    public static boolean isPossible(String[][] park, int len) {
      int height = park.length;

      int width = park[0].length;

      for (int i = 0; i <= height - len; i++) {
        for (int j = 0; j <= width - len; j++) {
          boolean ok = true;

          for (int a = i; a < i + len; a++) {
            for (int b = j; b < j + len; b++) {
              if (!park[a][b].equals("-1")) {
                ok = false;
                break;
              }
            }
          }
          if (ok) {
            return true;
          }
        }
      }
      return false;
    }

    public int solution(int[] mats, String[][] park) {
      int answer = -1;

      for (int mat : mats) {
        if (isPossible(park, mat)) {
          answer = Math.max(answer, mat);
        }
      }
      // mats 배열을 미리 오름차순으로 sort 후 바로 return 하는 방식도 가능할 듯


      return answer;
    }
  }

