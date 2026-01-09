package BaekAlgo.divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 종이의_개수_1780 {

  public static int[][] paper;

  public static int[] count = new int[3];

  public static void divide(int row, int col, int d) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        dq(row + d * i, col + d * j, d);
      }
    }
  }

  public static void dq(int row, int col, int n) {
    int next = n/3;

    for (int i = row; i < row + n; i++) {
      for (int j = col; j < col + n; j++) {
        if (paper[row][col] != paper[i][j]) {
          divide(row, col, next);
          return;
        }
      }
    }

    count[paper[row][col] + 1]++;
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

    for (int num : count) {
      System.out.println(num);
    }

  }
}