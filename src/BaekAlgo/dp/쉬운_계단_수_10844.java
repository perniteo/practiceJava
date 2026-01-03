package BaekAlgo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 쉬운_계단_수_10844 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[][] dp = new int[n][10];

    Arrays.fill(dp[0], 1);
    dp[0][0] = 0;

    final int REMINDER = 1_000_000_000;

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < 10; j++) {
        if (j == 0) {
        dp[i][j] = dp[i-1][1];
        } else if (j == 9) {
          dp[i][j] = dp[i-1][8];
        } else {
          dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
        }
        dp[i][j] %= REMINDER;
      }
    }

    long answer = 0;

    for (int num : dp[n - 1]) {
      answer = (answer + num) % REMINDER;
    }

    System.out.println(answer);

  }
}