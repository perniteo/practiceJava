package Programmers.월간_코드_챌린지_시즌2;

import java.util.*;

class 괄호_회전하기 {

  // 괄호 회전하기 (stack)
    
    static boolean isCorrect(ArrayList<Character> list) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

      for (char next : list) {
        if (next == '[' || next == '(' || next == '{') {
          stack.push(next);
        } else if (next == ']') {
          if (!stack.isEmpty() && stack.peek() == '[') {
            stack.pop();
          } else {
            stack.push(next);
          }
        } else if (next == '}') {
          if (!stack.isEmpty() && stack.peek() == '{') {
            stack.pop();
          } else {
            stack.push(next);
          }
        } else if (next == ')') {
          if (!stack.isEmpty() && stack.peek() == '(') {
            stack.pop();
          } else {
            stack.push(next);
          }
        }
      }
        
        return stack.isEmpty();
    }
    
    public int solution(String s) {
        int answer = 0;
        
        ArrayList<Character> list = new ArrayList<>();
    
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        
        for (int i = 0; i < s.length(); i++) {
          if (isCorrect(list)) {
            answer++;
          }
            list.add(list.remove(0));
        }
        
        return answer;
    }
}