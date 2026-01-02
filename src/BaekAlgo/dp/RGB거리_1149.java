package BaekAlgo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리_1149 {

  // 현재 dp 상태 저장 -> 2차원 배열
  // 상태 3개 필요 -> 상태 변수 3개로 표현 가능

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[][] dp = new int[n][3];

    StringTokenizer st = new StringTokenizer(br.readLine());

    dp[0][0] = Integer.parseInt(st.nextToken());
    dp[0][1] = Integer.parseInt(st.nextToken());
    dp[0][2] = Integer.parseInt(st.nextToken());

    for (int i = 1; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      dp[i][0] += Integer.parseInt(st.nextToken()) + Math.min(dp[i-1][1], dp[i-1][2]);
      dp[i][1] += Integer.parseInt(st.nextToken()) + Math.min(dp[i-1][0], dp[i-1][2]);
      dp[i][2] += Integer.parseInt(st.nextToken()) + Math.min(dp[i-1][0], dp[i-1][1]);
    }

    int answer = Integer.MAX_VALUE;

    for (int cost : dp[n-1]) {
      answer = Math.min(cost, answer);
    }

    System.out.println(answer);
  }
}