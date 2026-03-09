package Programmers.Lv3;

import java.util.*;

class PQ_야근_지수 {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.add(work);
        }
        
        while (!pq.isEmpty() && n > 0) {
            int num = pq.poll() - 1;
            if (num > 0) {
                pq.add(num);
            }
            n--;
        }
        
        for (int q : pq) {
            answer += (long) q * q;
        }
        
        return answer;
    }
}