package BaekAlgo.graph.bfs.벽_부수고_이동하기_2206;

import java.io.*;
import java.util.*;

public class refactor1 {

  // 135804kb	1028ms

  // dist 배열 객체 + Queue 에서 int[] 배열 객체 + 가지 치기 안함

  // 3가지가 겹쳐서 solve 나왔지만 다소 아쉬운 효율

  static int n;
  static int m;

  static boolean[][] graph;

  static boolean[][][] visited;

  static int[][][] dist;

  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};

  public static void bfs() {
    dist[1][1][0] = 1;
    visited[1][1][0] = true;
    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[]{1, 1, 0});

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int r = cur[0];
      int c = cur[1];
      int d = cur[2];

      for (int i = 0; i < 4; i++) {
        int nr = r + dr[i];
        int nc = c + dc[i];

        if (nr < 1 || nc < 1 || nr > n || nc > m) {
          continue;
        }

        if (graph[nr][nc] && d == 0 && !visited[nr][nc][1]) {
          q.offer(new int[]{nr, nc, 1});
          visited[nr][nc][1] = true;
          dist[nr][nc][1] = dist[r][c][d] + 1;
        }

        if (!graph[nr][nc] && !visited[nr][nc][d]) {
          q.offer(new int[]{nr, nc, d});
          visited[nr][nc][d] = true;
          dist[nr][nc][d] = dist[r][c][d] + 1;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());

    m = Integer.parseInt(st.nextToken());

    graph = new boolean[n+1][m+1];
    visited = new boolean[n+1][m+1][2];
    dist = new int[n+1][m+1][2];

    for (int i = 1; i <= n; i++) {
      String input = br.readLine();
      for (int j = 1; j<= m; j++) {
        graph[i][j] = input.charAt(j-1) == '1';
      }
    }

    bfs();

    int result = Integer.MAX_VALUE;

    for (int r : dist[n][m]) {
      if (r > 0) {
        result = Math.min(result, r);
      }
    }

    System.out.println(result == Integer.MAX_VALUE ? -1 : result);
  }
}