package BaekAlgo.backTracking;

import java.io.*;
import java.util.*;

public class N과M_2_15650 {

  // 조합 backtracking
  // 정확히는 dfs-bf

  static int[] result;

  static int n;

  static int m;

  static StringBuilder sb = new StringBuilder();

  public static void dfs(int depth, int start) {
    if (depth == m) {
      for (int num : result) {
        sb.append(num).append(' ');
      }
      sb.append('\n');
      return;
    }

    for (int i = start; i <= n; i++) {

      result[depth] = i;
      dfs(depth + 1, i + 1);

    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());

    m = Integer.parseInt(st.nextToken());

    result = new int[m];

    dfs(0, 1);

    System.out.println(sb);

  };
}