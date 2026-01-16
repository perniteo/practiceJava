package BaekAlgo.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의_이동_7562 {

  static int[][] graph;

  static int[] goal;

  static int n;

  static int[] dr = {2, 2, -2, -2, 1, 1, -1, -1};
  static int[] dc = {1, -1, 1, -1, 2, -2, 2, -2};

  public static int bfs(int r, int c) {
    graph[r][c] = 1;

    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[]{r, c});

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      int row = cur[0];
      int col = cur[1];

      if (row == goal[0] && col == goal[1]) {
        return graph[row][col] - 1;
      }

      for (int i = 0; i < 8; i++) {
        int nr = row + dr[i];
        int nc = col + dc[i];

        if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;

        if (graph[nr][nc] == 0) {
          graph[nr][nc] = graph[row][col] + 1;
          q.offer(new int[]{nr, nc});
        }
      }

    }

    return -1;
  }



  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < t; i++ ) {
      n = Integer.parseInt(br.readLine());

      graph = new int[n][n];

      StringTokenizer st = new StringTokenizer(br.readLine());

      int row = Integer.parseInt(st.nextToken());

      int col = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());

      goal = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

      sb.append(bfs(row, col)).append("\n");
    }

    System.out.println(sb);
  }
}