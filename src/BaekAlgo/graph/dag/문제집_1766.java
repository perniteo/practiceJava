package BaekAlgo.graph.dag;

import java.io.*;
import java.util.*;

public class 문제집_1766 {

  // 위상 정렬

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] degree = new int[n + 1];

    List<List<Integer>> graph = new ArrayList<>();

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph.get(a).add(b);
      degree[b]++;
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i = 1; i <= n; i++) {
      if (degree[i] == 0) {
        pq.add(i);
      }
    }

    while (!pq.isEmpty()) {
      int cur = pq.poll();
      sb.append(cur).append(" ");

      for (int num : graph.get(cur)) {
        degree[num]--;

        if (degree[num] == 0) {
          pq.add(num);
        }
      }
    }

    System.out.println(sb);
  }
}
