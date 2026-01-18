package BaekAlgo.graph.bfs.벽_부수고_이동하기_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class refactor3 {

  // 106300kb	796ms

  // dist 배열을 삭제하고 queue 에서 변수 하나로 처리

  // 유의미한 성능 개선에 성공

  // queue 에서 Node 객체를 정의하여 사용하는 것이 조금 더 유연할 듯함

  // 극의에 달하면 int bit masking 으로 다 표현이 가능할 것으로 보임

  static int n;
  static int m;

  static boolean[][] graph;

  static boolean[][][] visited;

  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};

  public static void bfs() {
    visited[1][1][0] = true;
    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[]{1, 1, 0, 1});

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int r = cur[0];
      int c = cur[1];
      int d = cur[2];
      int depth = cur[3];

      if (r == n && c == m) {
        System.out.println(depth);
        return;
      }

      for (int i = 0; i < 4; i++) {
        int nr = r + dr[i];
        int nc = c + dc[i];

        if (nr < 1 || nc < 1 || nr > n || nc > m) continue;

        if (graph[nr][nc] && d == 0 && !visited[nr][nc][1]) {
          q.offer(new int[]{nr, nc, 1, depth + 1});
          visited[nr][nc][1] = true;

        }

        if (!graph[nr][nc] && !visited[nr][nc][d]) {
          q.offer(new int[]{nr, nc, d, depth + 1});
          visited[nr][nc][d] = true;
        }
      }
    }
    System.out.println(-1);
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());

    m = Integer.parseInt(st.nextToken());

    graph = new boolean[n+1][m+1];
    visited = new boolean[n+1][m+1][2];

    for (int i = 1; i <= n; i++) {
      String input = br.readLine();
      for (int j = 1; j<= m; j++) {
        graph[i][j] = input.charAt(j-1) == '1';
      }
    }

    bfs();
  }
}