package BaekAlgo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파도반_수열_9461 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    long[] dp = new long[101];
    dp[1] = dp[2] = dp[3] = 1;
    dp[4] = dp[5] = 2;

    for (int i = 6; i <= 100; i++) {
      dp[i] = dp[i-1] + dp[i-5];
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      sb.append(dp[n]).append('\n');
    }

    System.out.println(sb);

  }
}