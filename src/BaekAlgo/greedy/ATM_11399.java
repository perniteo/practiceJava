package BaekAlgo.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM_11399 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] times = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      times[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(times);

    int sumTakenTime = 0;

    for (int i = 0; i < n; i++) {
      sumTakenTime += times[i] * (n - i);
    }

    System.out.println(sumTakenTime);

  }
}