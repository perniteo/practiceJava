package BaekAlgo.divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드트리_1992 {

  public static StringBuilder sb = new StringBuilder();

  public static boolean[][] media;

  public static void dq(int row, int col, int n) {
    int next = n/2;

    for (int i = row; i < row + n; i++) {
      for (int j = col; j < col + n; j++) {
        if (media[row][col] != media[i][j]) {
          sb.append("(");
          dq(row, col, next);
          dq(row, col + next, next);
          dq(row + next, col, next);
          dq(row + next, col + next, next);
          sb.append(")");
          return;
        }
      }
    }

    sb.append(media[row][col] ? 1 : 0);
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    media = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      String input = br.readLine();
      for (int j = 0; j < n; j++) {
        media[i][j] = input.charAt(j) - '0' == 1;
      }
    }

    dq(0, 0, n);

    System.out.println(sb);

  }
}