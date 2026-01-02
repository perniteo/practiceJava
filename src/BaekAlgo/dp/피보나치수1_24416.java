package BaekAlgo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수1_24416 {

  static int recursionCount = 0;
  static int dpCount = 0;
  static int[] dp;

  public static int fibonacci1(int n) {
    if (n == 1 || n == 2) {
      recursionCount++;
      return 1;
    }

    return fibonacci1(n - 1) + fibonacci1(n - 2);
  }

  public static int fibonacci2(int n) {

    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i-1] + dp[i-2];
      dpCount++;
    }

    return dp[n];
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 1;

    fibonacci1(n);
    fibonacci2(n);
    System.out.println(recursionCount + " " + dpCount);

  }

}