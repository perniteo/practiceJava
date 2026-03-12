package Programmers.KAKAO.인턴십2019;

import java.util.*;

class 징검다리_건너기 {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < stones.length; i++) {
            
            while (!dq.isEmpty() 
                   && stones[dq.peekLast()] <= stones[i]) {
                dq.pollLast();
            }
            
            dq.addLast(i);
            
            if (dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            
            if (i >= k - 1) {
                answer = Math.min(answer, stones[dq.peekFirst()]);
            }
            
        }
        
        return answer;
    }
}