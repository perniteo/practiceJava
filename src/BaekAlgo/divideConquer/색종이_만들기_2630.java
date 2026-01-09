package BaekAlgo.divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이_만들기_2630 {

  static int[][] paper;

  static int white = 0;
  static int blue = 0;

  public static void dq(int row, int col, int n) {

    boolean isWhite = paper[row][col] == 0;

    for (int i = row; i < row + n; i++) {
      for (int j = col; j < col + n; j++) {
        if ((isWhite && paper[i][j] == 1) || (!isWhite && paper[i][j] == 0)) {
          dq(row, col, n/2);
          dq(row + n/2, col, n/2);
          dq(row, col + n/2, n/2);
          dq(row + n/2, col + n/2, n/2);
          return;
        }
      }
    }

    if (isWhite) white++;
    else blue++;

  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    paper = new int[n][n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dq(0, 0, n);

    System.out.println(white);
    System.out.println(blue);
  }
}