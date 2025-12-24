package BaekAlgo.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 괄호_9012 {
  
  // ) 를 입력받았을 때는 반드시 ( 를 pop 시킬 수 있어야 함
  // 그게 불가능할 때는 stack 이 비어있을 때 == false
  // 이 논리를 이해할 것

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    Deque<Character> stack;

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < t; i++) {
      stack = new ArrayDeque<>();
      String commands = br.readLine();

      boolean ok = true;

      for (int c = 0; c < commands.length(); c++) {
        char curr = commands.charAt(c);

        if (curr == '(') {
          stack.push(curr);
        } else {
          if (stack.isEmpty()) {
            ok = false;
            break;
          }
          stack.pop();
        }

      }
      sb.append(ok && stack.isEmpty() ? "YES\n" : "NO\n");

    }

    System.out.println(sb);

  }
}