package BaekAlgo.graph.bfs;

import java.io.*;
import java.util.*;

public class 불_4179 {

  static int r;
  static int c;

  static int[][] dist;

  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};

  static ArrayDeque<int[]> fq = new ArrayDeque<>();

  static int bfs(int hr, int hc) {
    ArrayDeque<int[]> hq = new ArrayDeque<>();

    hq.offer(new int[]{hr, hc});

    while (!hq.isEmpty()) {

      int hSize = hq.size();
      int fSize = fq.size();

      for (int i = 0; i < hSize; i++) {
        int[] n = hq.poll();
        int cr = n[0];
        int cc = n[1];

        if (dist[cr][cc] < 0) {
          continue;
        }

        for (int j = 0; j < 4; j++) {
          int nr = cr + dr[j];
          int nc = cc + dc[j];
          if (dist[nr][nc] == -1 || dist[nr][nc] == -2) {
            continue;
          }

          if (nr < 1 || nc < 1 || nr > r || nc > c) {
            return dist[cr][cc] + 1;
          }
          if (dist[nr][nc] == 0) {
            dist[nr][nc] = dist[cr][cc] + 1;
            hq.offer(new int[]{nr, nc});
          }
        }
      }

      for (int i = 0; i < fSize; i++) {
        int[] n = fq.poll();
        int cr = n[0];
        int cc = n[1];

        for (int j = 0; j < 4; j++) {
          int nr = cr + dr[j];
          int nc = cc + dc[j];

          if (nr < 1 || nc < 1 || nr > r || nc > c) {
            continue;
          }
          if (dist[nr][nc] == -1 || dist[nr][nc] == -2) {
            continue;
          }
          if (dist[nr][nc] >= 0) {
            dist[nr][nc] = -2;
            fq.offer(new int[]{nr, nc});
          }
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    dist = new int[r+2][c+2];

    int hr = 0, hc = 0;

    for (int i = 1; i <= r; i++) {
      String str = br.readLine();
      for (int j = 1; j <= c; j++) {
        char ch = str.charAt(j-1);
        if (ch == '#') {
          dist[i][j] = -1;
        } else if (ch == 'J') {
          hr = i;
          hc = j;
        } else if (ch == 'F') {
          dist[i][j] = -2;
          fq.offer(new int[]{i, j});
        }
      }
    }

    int result = bfs(hr, hc);

    System.out.println(result == -1 ? "IMPOSSIBLE" : result);

  }
}
