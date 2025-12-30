package BaekAlgo.backTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class N_Queen_9663 {

  // n-queen 대각선 성질을 이용해서 1차원 배열 3개 사용

  static boolean[] col;
  static boolean[] diag1;
  static boolean[] diag2;

  static int count = 0;
  static int n;

  public static void dfs(int row) {
    if (row == n) {
      count++;
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!col[i] && !diag1[i + row] && !diag2[i - row + n - 1]) {
        col[i] = diag1[i + row] = diag2[i - row + n - 1] = true;
        dfs(row + 1);
        col[i] = diag1[i + row] = diag2[i - row + n - 1] = false;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    col = new boolean[n];
    diag1 = new boolean[2 * n - 1];
    diag2 = new boolean[2 * n - 1];

    dfs(0);

    System.out.println(count);

  };
}