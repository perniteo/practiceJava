package BaekAlgo.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 미확인_도착지_9370 {

  // g, h를 경유하는 경로가 최단 경로인지 판별하는 로직
  // 문제 조건에서 g-h 간선을 목적지 후보로 가는 최단 경로로 보장해줬기 때문에
  // s -> g -> h -> goal || s -> h -> g -> goal 만 해도 g-h 간선을 따라서 갔다고 보장이 가능함
  // 그렇기 때문에 s -> goal 과 비교했을 때 같다면 g-h 간선을 경유하는 route 가 최적임을 증명하는 것

  // 그렇지 않을 경우에는 각 가중치를 2배로 해서 짝수로 고정
  // g-h 간선은 (2 * weight - 1)을 줘서 홀수를 보장할 수 있음
  // 따라서 결과값이 홀수면 g-h를 경유했다고 볼 수 있겠다.

  static ArrayList<ArrayList<Node>> graph;

  final static int INF = Integer.MAX_VALUE;

  static int n;

  static long[] distS;
  static long[] distG;
  static long[] distH;

  static int[] goals;

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
    Arrays.fill(dist, INF);

    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.w));

    pq.add(new Node(start, 0));
    dist[start] = 0;

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

    int test = Integer.parseInt(br.readLine());

    StringTokenizer st;

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < test; i++) {
      st = new StringTokenizer(br.readLine());

      n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());

      graph = new ArrayList<>();

      goals = new int[t];

      for (int j = 0; j <= n; j++) {
        graph.add(new ArrayList<>());
      }

      st = new StringTokenizer(br.readLine());

      int s = Integer.parseInt(st.nextToken());
      int g = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());

      for (int j = 0; j < m; j++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        graph.get(a).add(new Node(b, d));
        graph.get(b).add(new Node(a, d));
      }

      for (int j = 0; j < t; j++) {
        int goal = Integer.parseInt(br.readLine());
        goals[j] = goal;
      }

      Arrays.sort(goals);

      distS = dijkstra(s);
      distG = dijkstra(g);
      distH = dijkstra(h);

      for (int goal : goals) {
        long case1 = distS[g] + distG[h] + distH[goal];
        long case2 = distS[h] + distH[g] + distG[goal];

        long result = Math.min(case1, case2);

        long result2 = distS[goal];

        sb.append(result == result2 ? goal + " " : "");
      }

      sb.append("\n");
    }

    System.out.println(sb);
  }
}
