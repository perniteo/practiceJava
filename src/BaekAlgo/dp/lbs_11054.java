package BaekAlgo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class lbs_11054 {

  // lis + lds, dp

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] lis = new int[n];

    int[] lds = new int[n];

    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; i++) {
      lis[i] = 1;
      lds[n - i - 1] = 1;
      for (int j = 0 ; j < i; j++) {
        if (arr[i] > arr[j]) {
          lis[i] = Math.max(lis[i], lis[j] + 1);
        }
        if (arr[n - i - 1] > arr[n - j - 1]) {
          lds[n - i - 1] = Math.max(lds[n - i - 1], lds[n - j - 1] + 1);
        }
      }
    }

    int answer = 0;

    for (int i = 0; i < n; i++) {
      answer = Math.max(lis[i] + lds[i], answer);
    }

    System.out.println(answer - 1);
  }
}