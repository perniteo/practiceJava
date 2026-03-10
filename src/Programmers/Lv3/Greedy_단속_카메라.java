package Programmers.Lv3;

import java.util.*;

class Greedy_단속_카메라 {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (a, b) -> {
            return a[1] - b[1];
        });
        
        int cur = routes[0][1];
        
        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            if (cur < route[0]) {
                cur = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}