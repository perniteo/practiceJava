package BaekAlgo.graph.dfs;

import java.io.*;
import java.util.*;

public class 이분그래프_1707 {

  // 정점을 두 집합으로 분할, 각 집합 정점은 인접하지 않는다
  // 인근 노드가 다른 색이라는 말

  static ArrayList<ArrayList<Integer>> graph;

  static boolean[] visited;

  static boolean[] color;

  static boolean dfs(int u) {

    for (int v : graph.get(u)) {
      if (!visited[v]) {
        visited[v] = true;
        color[v] = !color[u];
        if (!dfs(v)) return false;
      } else {
        if (color[v] == color[u]) {
          return false;
        }
      }
    }

    return true;
  }


  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int k = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < k; i++) {
      boolean isBipartite = true;

      graph = new ArrayList<>();

      StringTokenizer st = new StringTokenizer(br.readLine());

      int v = Integer.parseInt(st.nextToken());

      int e = Integer.parseInt(st.nextToken());

      visited = new boolean[v+1];
      color = new boolean[v+1];

      for (int j = 0; j <= v; j++) {
        graph.add(new ArrayList<>());
      }

      for (int j = 0; j < e; j++) {
        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        graph.get(start).add(end);
        graph.get(end).add(start);
      }

      for (int j = 1; j <= v; j++) {
        if (!visited[j]) {
          visited[j] = true;
          color[j] = true;
          if (!dfs(j)) {
            isBipartite = false;
            break;
          }
        }
      }
      sb.append(isBipartite ? "YES" : "NO").append("\n");
    }

    System.out.println(sb);

  }
}
