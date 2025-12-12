package Programmers.PCCE;

public class 지폐_접기_9번 {

    public int solution(int[] wallet, int[] bill) {
      int answer = 0;

      while ((bill[0] > wallet[0] || bill[1] > wallet[1]) &&
          (bill[0] > wallet[1] || bill[1] > wallet[0])) {
        if (bill[0] > bill[1]) {
          bill[0] = bill[0] / 2;
        } else {
          bill[1] = bill[1] / 2;
        }
        answer++;
      }
      System.out.printf("%d %d",bill[0], bill[1]);

      return answer;
    }
  }


