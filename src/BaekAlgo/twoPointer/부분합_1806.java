package BaekAlgo.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합_1806 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());

    int sum = 0;
    int len = 0;
    int shortest = Integer.MAX_VALUE;

    int[] list = new int[n];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      list[i] = Integer.parseInt(st.nextToken());
    }

    int i = 0;
    int j = 0;

    while (i < n) {
      if (sum < s && j < n) {
        sum += list[j++];
        len++;
        continue;
      } else if (sum >= s) {
        shortest = Math.min(shortest, len);
        sum -= list[i++];
        len--;
        continue;
      }
      break;
    }

    System.out.println(shortest == Integer.MAX_VALUE ? 0 : shortest);

  }
}
