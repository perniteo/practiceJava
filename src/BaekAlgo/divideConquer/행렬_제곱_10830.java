package BaekAlgo.divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬_제곱_10830 {

  static final long MOD = 1_000;

  static long[][] origin;

  static int n;

  public static long[][] mul(long[][] A, long[][] B) {
    long[][] C = new long[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        long sum = 0;
        for (int k = 0; k < n; k++) {
          sum = sum + A[i][k] * B[k][j];
        }
        C[i][j] = sum % MOD;
      }
    }

    return C;
  }

  public static long[][] dq(long[][] matrix, long b) {
    if (b == 1) {
      long[][] base = new long[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          base[i][j] = matrix[i][j] % MOD;
        }
      }
      return base;
    }

    long[][] half = dq(matrix, b / 2);
    long[][] res = mul(half, half);

    if (b % 2 == 1) {
      res = mul(res, origin);
    }

    return res;
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());

    long b = Long.parseLong(st.nextToken());

    long[][] matrix = new long[n][n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        matrix[i][j] = Long.parseLong(st.nextToken());
      }
    }

    origin = matrix;

    long[][] result = dq(matrix, b);

    StringBuilder sb = new StringBuilder();

    for (long[] r : result) {
      for (long num : r) {
        sb.append(num).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}