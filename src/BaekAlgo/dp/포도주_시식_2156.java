package BaekAlgo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주_시식_2156 {

  // 조건에 맞게 상태 구현할 것
  // 조건은 연속 3잔만 불가 --> 2개를 continue 하는 경우가 생길 수 있음

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[][] dp = new int[n + 1][3];

    int answer = 0;

    for (int i = 1; i <= n; i++) {
      int wine = Integer.parseInt(br.readLine());
      dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
      dp[i][1] = dp[i-1][0] + wine;
      dp[i][2] = dp[i-1][1] + wine;

      answer = Math.max(answer, Math.max(dp[i][0], Math.max(dp[i][1], dp[i][2])));
    }

    System.out.println(answer);

  }
}