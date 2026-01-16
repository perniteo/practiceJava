package BaekAlgo.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_2178 {

  static boolean[][] graph;

  static int[][] dist;

  static int n;
  static int m;

  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};

  public static int bfs(int r, int c) {
    dist[r][c] = 1;

    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[]{r, c});

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      int cr = cur[0];
      int cc = cur[1];

      for (int i = 0; i < 4; i++) {
        int nr = cr + dr[i];
        int nc = cc + dc[i];

        if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

        if (dist[nr][nc] == 0 && graph[nr][nc]) {
          q.offer(new int[]{nr, nc});
          dist[nr][nc] = dist[cr][cc] + 1;
        }
      }

    }

    return dist[n-1][m-1];
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());

    m = Integer.parseInt(st.nextToken());

    graph = new boolean[n][m];

    dist = new int[n][m];

    for (int i = 0; i < n; i++) {
      String input = br.readLine();
      for (int j = 0; j < m; j++) {
        graph[i][j] = input.charAt(j) == '1';
      }
    }

    System.out.println(bfs(0, 0));

  }
}