package BaekAlgo.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 균형잡힌_세상_4949 {

  // 괄호 문제에서 조건이 하나 늘어난 정도
  // 소괄호와 대괄호를 모두 처리

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Deque<Character> stack;

    StringBuilder sb = new StringBuilder();

    while (true) {
      String input = br.readLine();

      if (input.equals(".")) {
        break;
      }

      boolean ok = true;

      stack = new ArrayDeque<>();

      for (int i = 0; i < input.length(); i++) {

        char c = input.charAt(i);

        if (c == '[' || c == '(') {
          stack.push(c);
        } else if (c == ')' || c ==']') {
          if (stack.isEmpty()) {
            ok = false;
            break;
          }
          char last = stack.peek();
          if ((last == '(' && c == ')') || (last == '[' && c == ']')) {
            stack.pop();
          } else {
            ok = false;
            break;
          }
        }
      }

      sb.append(ok && stack.isEmpty() ? "yes\n" : "no\n");
    }

    System.out.println(sb);

  }
}