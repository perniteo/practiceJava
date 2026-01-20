package BaekAlgo.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 특정한_최단_경로_1504 {

  static ArrayList<ArrayList<Node>> graph;

  static long[] dist1;
  static long[] distA;
  static long[] distB;

  static int n;

  static int a;
  static int b;

  static class Node {
    int v;
    long w;
    Node(int v, long w) {
      this.v = v;
      this.w = w;
    }
  }

  static long[] dijkstra(int start) {
    long[] dist = new long[n+1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.w));
    pq.add(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (cur.w > dist[cur.v]) continue;

      for (Node e : graph.get(cur.v)) {
        long next = e.w + cur.w;

        if (dist[e.v] > next) {
          dist[e.v] = next;
          pq.add(new Node(e.v, next));
        }
      }
    }

    return dist;
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());

    int e = Integer.parseInt(st.nextToken());

    graph = new ArrayList<>();

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine());

      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      graph.get(u).add(new Node(v, w));
      graph.get(v).add(new Node(u, w));
    }

    st = new StringTokenizer(br.readLine());

    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());

    dist1 = dijkstra(1);
    distA = dijkstra(a);
    distB = dijkstra(b);

    long case1 = dist1[a] + distA[b] + distB[n];
    long case2 = dist1[b] + distB[a] + distA[n];

    long result = Math.min(case1, case2);

    System.out.println(result >= Integer.MAX_VALUE ? -1 : result);
  }
}
