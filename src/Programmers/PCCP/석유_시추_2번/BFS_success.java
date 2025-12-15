package Programmers.PCCP.석유_시추_2번;

import java.util.*;

class BFS_success {

// 각 석유 덩어리를 BFS로 한 번만 탐색한다.
// BFS 동안 덩어리의 크기(size)와 이 덩어리가 걸쳐 있는 열(Set<Integer>)을 기록한다.
// 탐색이 끝난 뒤, 해당 열들에 덩어리 크기를 더해 중복 계산을 방지한다.

// BFS = 석유 덩어리 단위 처리
// - size: 덩어리 전체 크기
// - cols: 이 덩어리가 포함된 열 목록
// 덩어리 탐색이 끝난 뒤 cols에 대해 colSum[col] += size 수행



  static int[] colSum;
  static boolean[][] visited;

  public static void bfs(int x, int y, int[][] land) {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    int size = 0;

    Queue<int[]> q = new LinkedList<>();
    Set<Integer> cols = new HashSet<>();

    q.add(new int[]{x, y});
    visited[x][y] = true;

    while (!q.isEmpty()) {
      int[] p = q.poll();

      int sx = p[0], sy = p[1];
      size++;

      cols.add(sy);
      for (int i = 0; i < 4; i++) {
        int nx = sx + dx[i];
        int ny = sy + dy[i];

        if (nx >= 0 && ny >= 0 && nx < land.length && ny < land[0].length && land[nx][ny] == 1 && !visited[nx][ny]) {

          visited[nx][ny] = true;
          q.add(new int[]{nx, ny});
        }
      }
    }

    for (int col : cols) {
      colSum[col] += size;
    }


  }

  public int solution(int[][] land) {
    int answer = 0;
    visited = new boolean[land.length][land[0].length];
    colSum = new int[land[0].length];

    for (int i = 0; i < land.length; i++) {
      for (int j = 0; j < land[0].length; j++) {
        if (land[i][j] == 1 && !visited[i][j]) {
          bfs(i, j, land);
        }
      }
    }

    for (int n : colSum) {
      answer = Math.max(answer, n);
    }

    return answer;
  }
}