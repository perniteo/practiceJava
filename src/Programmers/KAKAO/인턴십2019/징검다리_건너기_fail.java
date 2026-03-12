package Programmers.KAKAO.인턴십2019;

class 징검다리_건너기_fail {

    // greedy 라는 사실은 진작 알았지만 k값을 생각 못 해서 시간복잡도가 터져버림

    public int solution(int[] stones, int k) {
        int answer = 0;
        
        while (true) {
            int minStone = 200_000_000;
            
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] > 0) {
                    minStone = Math.min(minStone, stones[i]);
                }
            }
            
            answer += minStone;
            
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] > 0) {
                    stones[i] -= minStone; 
                }
            }
            
            int dist = 0;
            boolean canJump = true;
            
            for (int i = 0; i < stones.length; i++) {
                int stone = stones[i];
                if (stone == 0) {
                    dist++;
                    if (dist >= k) {
                        canJump = false;
                        break;
                    }
                } else {
                    dist = 0;
                }
            }

          if (!canJump) {
            break;
          }
        }
        
        return answer;
    }
}