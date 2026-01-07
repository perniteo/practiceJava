package BaekAlgo.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판_다시_칠하기2_25682 {

  // 메모리 절약 리팩토링 가능
  // --> bStart, ps 구분 하지 않고 ps에 바로 누적 가능

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[][] bStart = new int[n][m];

    for (int i = 0; i < n; i++) {
      String board = br.readLine();
      for (int j = 0; j < m; j++) {
        char color = board.charAt(j);

        if (color == 'W' && (i + j) % 2 == 0) {
          bStart[i][j]++;
        } else if (color == 'B' && (i + j) % 2 == 1) {
          bStart[i][j]++;
        }
      }
    }

    int[][] ps = new int[n+1][m+1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        ps[i][j] = bStart[i-1][j-1] + ps[i-1][j] + ps[i][j-1] - ps[i-1][j-1];
      }
    }

    int minValue = Integer.MAX_VALUE;

    for (int i = k; i <= n; i++) {
      for (int j = k; j <= m; j++) {
        int count1 = ps[i][j] - ps[i-k][j] - ps[i][j-k] + ps[i-k][j-k];
        int count2 = k * k - count1;
        int count = Math.min(count1, count2);
        minValue = Math.min(minValue, count);
      }
    }

    System.out.println(minValue);

  }
}