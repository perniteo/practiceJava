package BaekAlgo.divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬_곱셈_2740 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int aRow = Integer.parseInt(st.nextToken());

    int aCol = Integer.parseInt(st.nextToken());

    int[][] a = new int[aRow][aCol];

    for (int i = 0; i < aRow; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < aCol; j++) {
        int n = Integer.parseInt(st.nextToken());

        a[i][j] = n;
      }
    }

    st = new StringTokenizer(br.readLine());

    int bRow = Integer.parseInt(st.nextToken());

    int bCol = Integer.parseInt(st.nextToken());

    int[][] b = new int[bRow][bCol];

    for (int i = 0; i < bRow; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < bCol; j++) {
        int n = Integer.parseInt(st.nextToken());

        b[i][j] = n;
      }
    }

    StringBuilder sb = new StringBuilder();


    for (int i = 0; i < aRow; i++) {
      for (int j = 0; j < bCol; j++) {
        int num = 0;
        for (int k = 0; k < bRow; k++) {
          num += a[i][k] * b[k][j];
        }
        sb.append(num).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);

  }
}