package Programmers.KAKAO.BLIND2022;

import java.util.*;

// 구현
// 계산식이 난잡하긴 해서 refactoring 하면 좋을듯

class Impl_주차요금_계산 {
    public int[] solution(int[] fees, String[] records) {     
        int[] park = new int[10000];
        
        Map<Integer, Integer> parking = new HashMap<>();
        
        for (String record : records) {
            String[] r = record.split(" ");
            
            String[] t = r[0].split(":");
            
            int number = Integer.parseInt(r[1]);
            
            int time = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            
            if (r[2].equals("IN")) {
                parking.put(number, time);
            } else {
                int result = time - parking.get(number);
                park[number] += result;
                parking.remove(number);
            }
        }
        
        if (!parking.isEmpty()) {
            for (int n : parking.keySet()) {
                park[n] += 1439 - parking.get(n);
            }
        }
        
        int count = 0;
        
        ArrayList<Integer> sum = new ArrayList<>();
        
        for (int i = 0; i < 10000; i++) {
            if (park[i] != 0) {
                count++;
                sum.add(park[i]);
            }
        }
        
        int[] answer = new int[count];
        
        for (int i = 0; i < count; i++) {
            int s = sum.get(i);
            int cost = 0;
            if (s <= fees[0]) {
                cost += fees[1];
            } else {
                cost += fees[1];
                s -= fees[0];
                cost += s / fees[2] * fees[3];
                s %= fees[2];
                if (s > 0) {
                    cost += fees[3];
                }
            }
            answer[i] = cost;
        }
        
        return answer;
    }
}