
package BaekAlgo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수_삼각형_1932 {
  
  // 최대값 하나를 얻기 위해 bottom-up
  // 입력받을 때 마다 갱신하는 1차원 가능

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[][] dp = new int[n][n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j <= i; j++) {
        dp[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = n - 2; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        dp[i][j] += Math.max(dp[i+1][j], dp[i+1][j+1]);
      }
    }

    System.out.println(dp[0][0]);

  }
}