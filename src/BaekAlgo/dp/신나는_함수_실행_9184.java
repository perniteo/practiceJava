
package BaekAlgo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 신나는_함수_실행_9184 {

  static int[][][] dp;

  static StringBuilder sb;

  public static void appending(int a, int b, int c, int result) {
    sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(result).append("\n");
  }

  public static void initDp() {
    dp = new int[21][21][21];

    for (int i = 0; i <= 20; i++) {
      for (int j = 0; j <= 20; j++) {
        for (int k = 0; k <= 20; k++) {
          if (i == 0 || j == 0 || k == 0) {
            dp[i][j][k] = 1;
          }
          else if (i < j && j < k) {
            dp[i][j][k] = dp[i][j][k-1] + dp[i][j-1][k-1] - dp[i][j-1][k];
          }
          else {
            dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-1][k] + dp[i-1][j][k-1] - dp[i-1][j-1][k-1];
          }
        }
      }
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    sb = new StringBuilder();
    initDp();
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      if (a == -1 && b == -1 && c == -1) {
        break;
      }
      if (a <= 0 || b <= 0 || c <= 0) {
        appending(a, b, c, 1);
      } else if (a > 20 || b > 20 || c > 20) {
        appending(a, b, c , dp[20][20][20]);
      } else {
        appending(a, b, c, dp[a][b][c]);
      }
    }

    System.out.println(sb);
  }
}