package Programmers.KAKAO.카카오인턴십2020;

import java.util.*;

class Impl_수식_최대화 {
    
    String[] priority = new String[]{"*+-", "*-+", "-+*", "-*+", "+*-", "+-*"};
    
    ArrayList<String> conversion(String exp) {
        ArrayList<String> list = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(exp.charAt(0));
        
        for (int i = 1; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                list.add(sb.toString());
                list.add(String.valueOf(c));
                sb.setLength(0);
            }
        }
        
        list.add(sb.toString());
        
        return list;
    }
    
    long calc(long a, long b, char op) {
        long result = 0;
        
        switch (op) {
            case ('+') : result = a + b;
                break;
            case ('-') : result = a - b;
                break;
            case ('*') : result = a * b;
                break;
        }
        
        return result;
    }
    
    public long solution(String expression) {
        long answer = 0;
        
        for (String p : priority) {
            
            ArrayList<String> list = conversion(expression);
            
            for (int c = 0; c < 3; c++) {
                ArrayList<String> next = new ArrayList<>();
                char op = p.charAt(c);

                for (int i = 0; i < list.size(); i++) {
                    String token = list.get(i);
                    if (token.equals(String.valueOf(op))) {
                        long a = Long.parseLong(next.remove(next.size() - 1));
                        long b = Long.parseLong(list.get(++i));
                        
                        long result = calc(a, b, op);
                        next.add(String.valueOf(result));
                    } else {
                        next.add(token);
                    }
                }
                list = next;
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(list.get(0))));
        }
        
        return answer;
    }
}