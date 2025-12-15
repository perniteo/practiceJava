package Programmers.PCCP.석유_시추_2번;

public class DFS_fail {

  // 효율성 테스트 실패(시간 초과)
  // 말 그대로 효율이 낮다
  // 매번 열마다 새로운 측정을 하기 때문
  // 이게 커질수록 효율이 제곱으로 낮아짐

    public static void dfs(boolean[][] visited, int x, int y, int[][] land) {

      int[] dx = {0, 0, 1, -1};
      int[] dy = {1, -1, 0, 0};

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && ny >= 0 && nx < land.length && ny < land[0].length) {
          if (land[nx][ny] == 1 && !visited[nx][ny]) {
            visited[nx][ny] = true;
            dfs(visited, nx, ny, land);
          }
        }
      }


    }

    public int solution(int[][] land) {
      int answer = 0;

      for (int i = 0; i < land[0].length; i++) {
        boolean[][] visited = new boolean[land.length][land[0].length];
        for (int j = 0; j < land.length; j++) {
          if (land[j][i] == 1 && !visited[j][i]) {
            visited[j][i] = true;
            dfs(visited, j, i, land);
          }
        }
        int count = 0;

        for (boolean[] visit : visited) {
          for (boolean v : visit) {
            if (v) count++;
          }
        }
        answer = Math.max(answer, count);
      }

      return answer;
    }
  }

