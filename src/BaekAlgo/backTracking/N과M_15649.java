package BaekAlgo.backTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_15649 {

  // 순열 backtracking

  static boolean[] visited;

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
      if (visited[i]) {
        continue;
      }

      visited[i] = true;
      result[depth] = i;
      dfs(depth + 1);
      visited[i] = false;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());

    m = Integer.parseInt(st.nextToken());

    visited = new boolean[n + 1];

    result = new int[m];

    dfs(0);

    System.out.println(sb);

  };
}