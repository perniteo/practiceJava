package Programmers.Lv3;

import java.util.*;

class Heap_디스크_컨트롤러 {
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        
        int sumTime = 0;
        int curTime = 0;
        int count = 0;
        int idx = 0;
        
        Arrays.sort(jobs, (a, b) -> {
            return a[0] - b[0];
        });
        
        while (count < jobs.length) {
            
            while (idx < jobs.length && jobs[idx][0] <= curTime) {
                pq.add(jobs[idx++]);
            }
            
            if (pq.isEmpty()) {
                curTime = jobs[idx][0];
            } else {
                int[] disk = pq.poll();
                curTime += disk[1];
                sumTime += curTime - disk[0];
                count++;
            }
      
        }
        
        answer = sumTime / jobs.length;
        
        return answer;
    }
}