package BaekAlgo.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀과_사다리_게임_16928 {

  static int[] graph;
  static int count = 0;

  public static void bfs(int start) {
    Queue<Integer> q = new ArrayDeque<>();
    q.offer(start);
    graph[start] = -1;

    while (!q.isEmpty()) {
      int size = q.size();

      for (int s = 0; s < size; s++){
      int n = q.poll();
      if (n == 100) return;

        for (int i = 1; i <= 6; i++) {
          int next = n + i;
          if (next > 100) continue;
          if (graph[next] > 0) next = graph[next];

          if (graph[next] == 0) {
            graph[next] = -1;
            q.offer(next);
          }
        }
      }
      count++;
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    graph = new int[101];

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph[u] = v;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph[u] = v;
    }

    bfs(1);

    System.out.println(count);

  }
}