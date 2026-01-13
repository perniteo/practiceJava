package BaekAlgo.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 바이러스_2606 {

  static ArrayList<ArrayList<Integer>> graph;

  static boolean[] visited;

  static int count = -1;

  static void dfs(int cur) {
    visited[cur] = true;
    count++;

    ArrayList<Integer> next = graph.get(cur);

    for (int n : next) {
      if (!visited[n]) {
        dfs(n);
      }
    }
  }


  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int computer = Integer.parseInt(br.readLine());

    visited = new boolean[computer + 1];

    int edge = Integer.parseInt(br.readLine());

    graph = new ArrayList<>();

    for (int i = 0; i <= computer; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < edge; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    dfs(1);

    System.out.println(count);
  }
}