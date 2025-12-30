
package BaekAlgo.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 하노이의_탑_11729 {

  // 재귀 추상적 사고
  // 훈련 필요

  public static void hanoi(int n, int from, int via, int to) {
    if (n == 1) {
      System.out.println(from + " " + to);
      return;
    }

    hanoi(n - 1, from , to, via);
    System.out.println(from + " " + to);
    hanoi(n - 1, via, from, to);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    hanoi(n, 1, 2, 3);

  };
}