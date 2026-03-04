package Programmers.Lv2;

import java.util.*;

class Stack_과제_진행하기 {

    // stack + Impl + String
    
    class Subject {
        String name;
        int remain;
        
        Subject(String name, int remain) {
            this.name = name;
            this.remain = remain;
        }
    }
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        ArrayDeque<Subject> stack = new ArrayDeque<>();
        
        Arrays.sort(plans, (a, b) -> {
            return (Integer.parseInt(a[1].substring(0, 2)) * 60
                + Integer.parseInt(a[1].substring(3, 5)))
                - (Integer.parseInt(b[1].substring(0, 2)) * 60
                + Integer.parseInt(b[1].substring(3, 5)));
        });
        
        for (String[] plan : plans) {
            plan[1] = String.valueOf(
                Integer.parseInt(plan[1].substring(0, 2)) * 60 
                + Integer.parseInt(plan[1].substring(3, 5)));
        }
        
        int idx = 0;
        
        for (int i = 0; i < plans.length - 1; i++) {
            String[] cur = plans[i];
            String[] next = plans[i + 1];
            
            int t = Integer.parseInt(cur[2]);
            
            int gap = Integer.parseInt(next[1]) - Integer.parseInt(cur[1]);
            
            if (gap < t) {
                stack.push(new Subject(cur[0], t - gap));
            } else {
                gap -= t;
                answer[idx++] = cur[0];
                while (!stack.isEmpty() && gap > 0) {
                    Subject sub = stack.pop();
                    
                    if (sub.remain <= gap) {
                        gap -= sub.remain;
                        answer[idx++] = sub.name;
                    } else {
                        sub.remain -= gap;
                        gap = 0;
                        stack.push(sub);
                    }
                }
            }
        }
        
        answer[idx++] = plans[plans.length - 1][0];
        
        while (!stack.isEmpty()) {
            answer[idx++] = stack.pop().name;
        }
        
        return answer;
    }
}