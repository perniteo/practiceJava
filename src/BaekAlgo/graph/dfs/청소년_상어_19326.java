package BaekAlgo.graph.dfs;

import java.io.*;
import java.util.*;

public class 청소년_상어_19326 {

  // 어려웠음 원래는 전역변수를 통한 상태 복구 backtracking 선호했는데
  // 관리할 상태가 많아져서 복잡해지고 depth가 깊지 않을 때는 복사와 parameter로 넘겨주는 것도 좋은듯함

  static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
  static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};

  static int maxValue = 0;

  static void dfs(int[][] board, int[][] direction, int[][] pos, int r, int c, int num) {
    int fishValue = board[r][c];
    int sharkDir = direction[r][c];
    board[r][c] = 0;
    pos[fishValue][0] = -1;
    num += fishValue;
    maxValue = Math.max(maxValue, num);

    moveFish(board, direction, pos, r, c);

    for (int i = 1; i <= 3; i++) {
      int nr = r + dr[sharkDir] * i;
      int nc = c + dc[sharkDir] * i;

      if (nr < 0 || nc < 0 || nr > 3 || nc > 3 || board[nr][nc] == 0) {
        continue;
      }

      int[][] nBoard = copy(board);
      int[][] nDirection = copy(direction);
      int[][] nPos = copy(pos);

      dfs(nBoard, nDirection, nPos, nr, nc, num);
    }
  }

  static int[][] copy(int[][] origin) {
    int[][] result = new int[origin.length][origin[0].length];

    for (int i = 0; i < origin.length; i++) {
      result[i] = Arrays.copyOf(origin[i], origin[i].length);
    }

    return result;
  }

  static void moveFish(int[][] board, int[][] direction, int[][] pos, int r, int c) {
    for (int i = 1; i <= 16; i++) {
      int cr = pos[i][0];
      int cc = pos[i][1];

      if (cr == -1) {
        continue;
      }

      int cd = direction[cr][cc];

      for (int j = 0; j < 8; j++) {
        int nd = (cd + j) % 8;
        int nr = cr + dr[nd];
        int nc = cc + dc[nd];

        if (nr < 0 || nc < 0 || nr > 3 || nc > 3 || (nr == r && nc == c)) {
          continue;
        }

        direction[cr][cc] = nd;

        int targetFish = board[nr][nc];

        pos[i][0] = nr;
        pos[i][1] = nc;
        if (targetFish != 0) {
          pos[targetFish][0] = cr;
          pos[targetFish][1] = cc;
        }

        int tempBoard = board[cr][cc];
        board[cr][cc] = board[nr][nc];
        board[nr][nc] = tempBoard;

        int tempDir = direction[cr][cc];
        direction[cr][cc] = direction[nr][nc];
        direction[nr][nc] = tempDir;

        break;
      }
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[][] board = new int[4][4];
    int[][] direction = new int[4][4];
    int[][] pos = new int[17][2];

    for (int i = 0; i < 4; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 4; j++) {
        int value = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        board[i][j] = value;
        direction[i][j] = d - 1;
        pos[value][0] = i;
        pos[value][1] = j;
      }
    }

    dfs(board, direction, pos, 0, 0, 0);

    System.out.println(maxValue);

  }
}
