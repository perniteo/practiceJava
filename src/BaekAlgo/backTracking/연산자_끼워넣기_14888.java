package BaekAlgo.backTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자_끼워넣기_14888 {

  static int n;

  static int curr;

  static int max = Integer.MIN_VALUE;
  static int min = Integer.MAX_VALUE;

  static int[] arr;

  static int[] signs = new int[4];

  public static void dfs(int depth) {
    if (depth == n) {
      max = Math.max(max, curr);
      min = Math.min(min, curr);
      return;
    }

    for (int i = 0; i < 4; i++) {
      if (signs[i] > 0) {
        int prev = curr;
        signs[i]--;

        if (i == 0)
          curr += arr[depth];
        else if (i == 1)
          curr -= arr[depth];
        else if (i == 2)
          curr *= arr[depth];
        else
          curr /= arr[depth];

        dfs(depth + 1);

        curr = prev;
        signs[i]++;
      }
    }


  }


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    curr = Integer.parseInt(st.nextToken());

    arr = new int[n];

    arr[0] = curr;

    for (int i = 1; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < 4; i++) {
      signs[i] = Integer.parseInt(st.nextToken());
    }

    dfs(1);

    System.out.println(max);
    System.out.println(min);

  };
}