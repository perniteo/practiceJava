package BaekAlgo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단_오르기_2579 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[][] dp = new int[n+1][2];

    dp[1][0] = dp[1][1] = Integer.parseInt(br.readLine());

    for (int i = 2; i <= n; i++) {
      int score = Integer.parseInt(br.readLine());
      dp[i][0] = Math.max(dp[i-2][1], dp[i-2][0]) + score;
      dp[i][1] = dp[i-1][0] + score;
    }

    System.out.println(Math.max(dp[n][0], dp[n][1]));
  }
}