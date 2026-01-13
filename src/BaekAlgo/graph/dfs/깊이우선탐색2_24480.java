package BaekAlgo.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 깊이우선탐색2_24480 {

  // 양방향(무방향) graph, 내림차순

  static boolean[] visited;

  static int[] order;

  static ArrayList<ArrayList<Integer>> list;

  static int count = 1;

  public static void dfs(int cur) {
    order[cur] = count++;
    visited[cur] = true;

    for (int next : list.get(cur - 1)) {
      if (!visited[next]) {
        dfs(next);
      }
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    int m = Integer.parseInt(st.nextToken());

    int r = Integer.parseInt(st.nextToken());

    visited = new boolean[n+1];

    order = new int[n+1];

    list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      list.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      list.get(u-1).add(v);
      list.get(v-1).add(u);
    }

    for (int i = 0; i < n; i++) {
      list.get(i).sort((a, b) -> Integer.compare(b, a));
    }

    dfs(r);

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= n; i++) {
      sb.append(order[i]).append("\n");
    }

    System.out.println(sb);

  }
}