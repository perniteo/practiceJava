package BaekAlgo.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.StringTokenizer;

public class 너비우선탐색2_24445 {

  // 양방향(무방향) graph, 내림차순

  static boolean[] visited;

  static int[] order;

  static ArrayList<ArrayList<Integer>> list;

  static int count = 1;

  static Deque<Integer> deq = new ArrayDeque<>();

  public static void bfs(int cur) {
    visited[cur] = true;

    deq.offer(cur);

    while (!deq.isEmpty()) {
      int num = deq.poll();
      order[num] = count++;

      for (int n : list.get(num)) {
        if (!visited[n]) {
          deq.offer(n);
          visited[n] = true;
        }
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

    for (int i = 0; i <= n; i++) {
      list.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      list.get(u).add(v);
      list.get(v).add(u);
    }

    for (int i = 1; i <= n; i++) {
      list.get(i).sort(Comparator.reverseOrder());
    }

    bfs(r);

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= n; i++) {
      sb.append(order[i]).append("\n");
    }

    System.out.println(sb);

  }
}