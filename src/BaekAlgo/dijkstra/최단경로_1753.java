package BaekAlgo.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최단경로_1753 {

  static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

  static int[] dist;

  static class Node {
     int v;
     int w;
     Node (int v, int w) {
       this.v = v;
       this.w = w;
     }
  }

  static void dijkstra(int start) {
    Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));

    dist[start] = 0;

    pq.offer(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (cur.w > dist[cur.v]) continue;

      for (Node e : graph.get(cur.v)) {
        int next = cur.w + e.w;
        if (dist[e.v] > next) {
          dist[e.v] = next;
          pq.offer(new Node(e.v, next));
        }
      };
    }

  }


  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    dist = new int[n+1];

    Arrays.fill(dist, Integer.MAX_VALUE);

    int e = Integer.parseInt(st.nextToken());

    int k = Integer.parseInt(br.readLine());

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine());

      int u = Integer.parseInt(st.nextToken());

      int v = Integer.parseInt(st.nextToken());

      int w = Integer.parseInt(st.nextToken());

      graph.get(u).add(new Node(v, w));
    }

    dijkstra(k);

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= n; i++) {
      sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
    }

    System.out.println(sb);

  }
}
