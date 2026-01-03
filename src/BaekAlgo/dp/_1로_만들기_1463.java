package BaekAlgo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1로_만들기_1463 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] dp = new int[n + 1];

    Arrays.fill(dp, 1000000);
    dp[n] = 0;

    for (int i = n; i >= 1; i--) {
      if (i % 3 == 0) {
        dp[i/3] = Math.min(dp[i] + 1, dp[i/3]);
      }
      if (i % 2 == 0) {
        dp[i/2] = Math.min(dp[i] + 1, dp[i/2]);
      }
      dp[i-1] = Math.min(dp[i] + 1, dp[i-1]);
    }

    System.out.println(dp[1]);
  }
}