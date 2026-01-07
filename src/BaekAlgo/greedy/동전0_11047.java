package BaekAlgo.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전0_11047 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] coins = new int[n];

    for (int i = 0; i < n; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }

    int minCount = 0;

    while (k != 0) {
      minCount += k / coins[n-1];
      k %= coins[n-1];
      n--;
    }

    System.out.println(minCount);

  }
}