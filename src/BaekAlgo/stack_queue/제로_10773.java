package BaekAlgo.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 제로_10773 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int k = Integer.parseInt(br.readLine());

    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < k; i++) {
      int num = Integer.parseInt(br.readLine());

      if (num == 0) {
        stack.pop();
      } else {
        stack.push(num);
      }
    }

    int answer = 0;

    for (int n : stack) {
      answer += n;
    }

    System.out.println(answer);
  }
}