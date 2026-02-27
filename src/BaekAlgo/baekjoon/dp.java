package BaekAlgo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class dp {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int weight = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    Set<Integer> s = new HashSet<>();

    boolean[][] dp = new boolean[weight + 1][15001];
    dp[1][0] = true;

    dp[1][Integer.parseInt(st.nextToken())] = true;

    for (int i = 1; i < weight; i++) {
      int w = Integer.parseInt(st.nextToken());

      for (int d = 0; d <= 15000; d++) {
        if (!dp[i][d]) continue;

        dp[i+1][d] = true;
        dp[i+1][d+w] = true;
        dp[i+1][Math.abs(d-w)] = true;
      }
    }

    int bead = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < bead; i++) {
      int b = Integer.parseInt(st.nextToken());
      sb.append(dp[weight][b] ? "Y" : "N").append(" ");
    }


    System.out.println(sb);
  }
}
