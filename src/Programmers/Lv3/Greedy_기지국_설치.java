package Programmers.Lv3;

import java.util.*;
import java.util.Map.Entry;

class Greedy_기지국_설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        ArrayList<Integer> dist = new ArrayList<>();

        int cur = 1;
        
        for (int i = 0; i < stations.length; i++) {
            int station = stations[i];
            
            if (station - w - cur > 0) {
                dist.add(station - w - cur);
            }
            cur = station + w + 1;
        }
        
        if (cur <= n) {
            dist.add(n - cur + 1);
        }
        
        int range = 2 * w + 1;
        
        for (int d : dist) {
            answer += (d + range - 1) / range;
        }

        return answer;
    }
}