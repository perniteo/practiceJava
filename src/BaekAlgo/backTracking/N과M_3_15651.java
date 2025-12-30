package BaekAlgo.backTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_3_15651 {

  // 중복 순열 backtracking
  // 이것도 정확히는 dfs-bf

  static int[] result;

  static int n;

  static int m;

  static StringBuilder sb = new StringBuilder();

  public static void dfs(int depth) {
    if (depth == m) {
      for (int num : result) {
        sb.append(num).append(' ');
      }
      sb.append('\n');
      return;
    }

    for (int i = 1; i <= n; i++) {

      result[depth] = i;
      dfs(depth + 1);

    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());

    m = Integer.parseInt(st.nextToken());

    result = new int[m];

    dfs(0);

    System.out.println(sb);

  };
}