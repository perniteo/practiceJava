package BaekAlgo.dp;

import java.io.*;
import java.util.*;

public class 로봇_조종하기_2169 {

  // GRAPH 로는 성능상 불가능
  // 분할 정복식 DP
  // 아래 이동은 고정이고 왼쪽 오른쪽 경우가 있으니 왼 위 오 방향에서 오는 경우 중 최대값을 DP

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int maxValue = 0;

    int[][] map = new int[n][m];

    int[][] L = new int[n][m];
    int[][] R = new int[n][m];
    int[][] dp = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    L[0][0] = R[0][0] = dp[0][0] = map[0][0];

    for (int i = 1; i < m; i++) {
      L[0][i] = map[0][i] + L[0][i - 1];
      R[0][i] = map[0][i] + R[0][i - 1];
      dp[0][i] = map[0][i] + dp[0][i - 1];
    }

    for (int i = 1; i < n; i++) {
      L[i][m - 1] = dp[i - 1][m - 1] + map[i][m - 1];
      R[i][0] = dp[i - 1][0] + map[i][0];
      for (int j = 1; j < m; j++) {
        L[i][m - j - 1] = map[i][m - j - 1] + Math.max(dp[i - 1][m - j - 1], L[i][m - j]);
        R[i][j] = map[i][j] + Math.max(dp[i - 1][j], R[i][j - 1]);
      }

      for (int j = 0; j < m; j++) {
        dp[i][j] = Math.max(L[i][j], R[i][j]);
      }
    }

    System.out.println(dp[n-1][m-1]);

  }
}
