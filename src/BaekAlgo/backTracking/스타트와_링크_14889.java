package BaekAlgo.backTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와_링크_14889 {

  // 조합 dfs
  // 2개만 조합은 2중 for

  static int n;

  static boolean[] team;

  static int[][] field;

  static int min = Integer.MAX_VALUE;

  public static void calc() {
    int start = 0;
    int link = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (team[i] && team[j]) {
          start += field[i][j] + field[j][i];
        } else if (!team[i] && !team[j]) {
          link += field[i][j] + field[j][i];
        }
      }
    }
    min = Math.min(min, Math.abs(start - link));
  }

  public static void dfs(int idx, int cnt) {
    if (cnt == (n / 2)) {
      calc();
      return;
    }

    for (int i = idx; i < n; i++) {
      if (!team[i]) {
        team[i] = true;
        dfs(i + 1, cnt + 1);
        team[i] = false;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    team = new boolean[n];

    team[0] = true;

    field = new int[n][n];

    StringTokenizer st;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        field[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(1, 1);

    System.out.println(min);

  };
}