package Programmers.현대모비스_2023;

import java.util.*;

class 상담원_인원 {

    // 복습 필요
    
    List<int[]> cases = new ArrayList<>();
    
    void dfs(int idx, int remain, int[] arr) {
        if (idx == arr.length - 1) {
            arr[idx] = remain;
            cases.add(arr.clone());
            return;
        }
        
        for (int i = 1; i <= remain - (arr.length - idx - 1); i++) {
            arr[idx] = i;
            dfs(idx + 1, remain - i, arr);
        }
    }
    
    public int solution(int k, int n, int[][] reqs) {
        int answer = Integer.MAX_VALUE;
        
        List<ArrayList<int[]>> reqByType = new ArrayList<>();
        
        for (int i = 0; i < k; i++) {
            reqByType.add(new ArrayList<int[]>());
        }

        for (int i = 0; i < reqs.length; i++) {
            int[] req = reqs[i];
            reqByType.get(req[2] - 1).add(new int[]{req[0], req[1]});
        }
        
        dfs(0, n, new int[k]);
        
        for (int[] c : cases) {

            int totalWait = 0;
            
            for (int i = 0; i < k; i++) {
                ArrayList<int[]> rbt = reqByType.get(i);
                
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                
                int mentor = c[i];
                
                for (int[] r : rbt) {
                    int start = r[0];
                    int duration = r[1];
                    
                    if (pq.size() < mentor) {
                        pq.offer(start + duration);
                    } else {
                        int end = pq.poll();
                        
                        if (end > start) {
                            totalWait += end - start;
                            pq.offer(end + duration);
                        } else {
                            pq.offer(start + duration);
                        }
                    }
                }    
            }
            
            answer = Math.min(totalWait, answer);
        }
        
        return answer;
    }
}