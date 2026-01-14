package BaekAlgo.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와_BFS_1260 {

  static ArrayList<ArrayList<Integer>> graph;

  static boolean[] visited;

  static StringBuilder sb = new StringBuilder();

  public static void dfs(int cur) {
    visited[cur] = true;
    sb.append(cur).append(" ");

    for (int next : graph.get(cur)) {
      if (!visited[next]) {
        dfs(next);
      }
    }
  }

  public static void bfs(int cur) {
    Queue<Integer> q = new ArrayDeque<>();

    q.offer(cur);
    visited[cur] = true;

    while (!q.isEmpty()) {
      int n = q.poll();
      sb.append(n).append(" ");

      for (int next : graph.get(n)) {
        if (!visited[next]) {
          q.offer(next);
          visited[next] = true;
        }
      }
    }
  }


  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    int m = Integer.parseInt(st.nextToken());

    int v = Integer.parseInt(st.nextToken());

    graph = new ArrayList<>();

    visited = new boolean[n+1];

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    for (int i = 1; i <= n; i++) {
      graph.get(i).sort(Comparator.comparing(a -> a));
    }

    dfs(v);

    visited = new boolean[n+1];
    sb.append("\n");

    bfs(v);

    System.out.println(sb);
  }
}