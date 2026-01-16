package BaekAlgo.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질_1697 {

  // dp와 헷갈릴 수 있는 문제
  // cycle 존재하고 위상 정렬이 불가능하기 때문에 bfs
  // 내가 느낀 건 cycle이 존재하다는 것은 monotonic 하지 않다는 것

  static int[] dist;

  static int m;

  static int bfs(int n) {
    Queue<Integer> q = new ArrayDeque<>();

    q.offer(n);
    dist[n] = 1;

    while (!q.isEmpty()) {
      int c = q.poll();

      if (c == m) {
        return dist[c] - 1;
      }

      if (c * 2 < dist.length && dist[c * 2] == 0) {
        dist[c * 2] = dist[c] + 1;
        q.offer(c * 2);
      }
      if (c + 1 < dist.length && dist[c + 1] == 0) {
        dist[c + 1] = dist[c] + 1;
        q.offer(c + 1);
      }
      if (c - 1 >= 0 && dist[c - 1] == 0) {
        dist[c - 1] = dist[c] + 1;
        q.offer(c - 1);
      }
    }

    return -1;


  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    dist = new int[Math.max(n, m) * 2 + 1];

    System.out.println(bfs(n));
  }
}