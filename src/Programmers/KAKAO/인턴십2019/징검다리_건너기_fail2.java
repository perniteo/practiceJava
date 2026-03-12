package Programmers.KAKAO.인턴십2019;

class 징검다리_건너기_fail2 {

    // 여전히 시간에 걸림

    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        
        int n = stones.length;
        
        for (int i = 0; i <= n - k; i++) {
            int num = 0;
            for (int j = i; j < i + k; j++) {
                num = Math.max(stones[j], num);
            }
            answer = Math.min(answer, num);
        }
        
        return answer;
    }
}