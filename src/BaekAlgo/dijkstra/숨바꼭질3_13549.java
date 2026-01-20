package BaekAlgo.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숨바꼭질3_13549 {

  // 가중치가 0 or 1인 최단경로

  static int[] dist;

  static int k;

  static int dijkstra(int start) {
    Arrays.fill(dist, Integer.MAX_VALUE);

    dist[start] = 0;

    ArrayDeque<Integer> dq = new ArrayDeque<>();

    dq.addFirst(start);

    while (!dq.isEmpty()) {
      int cur = dq.pollFirst();

      if (cur == k) return dist[k];

      int next = cur * 2;
      if (next < dist.length && dist[next] > dist[cur]) {
        dist[next] = dist[cur];
        dq.addFirst(next);
      }

      next = cur + 1;
      if (next < dist.length && dist[next] > dist[cur] + 1) {
        dist[next] = dist[cur] + 1;
        dq.addLast(next);
      }

      next = cur - 1;
      if (next >= 0 && dist[next] > dist[cur] + 1) {
        dist[next] = dist[cur] + 1;
        dq.addLast(next);
      }


    }

    return dist[k];
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    k = Integer.parseInt(st.nextToken());

    dist = new int[Math.max(n, k) * 2];

    System.out.println(dijkstra(n));
  }
}
