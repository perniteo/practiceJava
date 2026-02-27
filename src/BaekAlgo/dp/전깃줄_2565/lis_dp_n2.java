package BaekAlgo.dp.전깃줄_2565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class lis_dp_n2 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[][] arr = new int[n][2];

    StringTokenizer st;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      arr[i][0] = a;
      arr[i][1] = b;
    }

    Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

    int[] dp = new int[n];

    for (int i = 0; i < n; i++) {
      dp[i] = 1;

      for (int j = 0; j < i; j++) {
        if (arr[i][1] > arr[j][1]) {
          dp[i] = Math.max(dp[j] + 1, dp[i]);
        }
      }
    }

    int lis = 0;

    for (int num : dp) {
      lis = Math.max(num, lis);
    }

    System.out.println(n - lis);

  }
}