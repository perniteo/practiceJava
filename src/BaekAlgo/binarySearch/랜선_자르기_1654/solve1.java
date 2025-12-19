package BaekAlgo.binarySearch.랜선_자르기_1654;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class solve1 {

  static int[] cables;

  public static long count(long len, int n) {
    long c = 0;

    for (int i = cables.length - 1; i >= 0; i--) {
      c += cables[i] / len;
      if (c >= n) {
        return c;
      }
    }

    return c;
  }

  public static long binarySearch(int n, long maxLen) {
    long len = 0;

    long left = 1;
    long right = maxLen;

    while (left <= right) {
      long mid = (right - left) / 2 + left;

      if (count(mid, n) >= n) {
        left = mid + 1;
        len = mid;
      } else {
        right = mid - 1;
      }
    }

    return len;
  }


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int k = Integer.parseInt(st.nextToken());

    int n = Integer.parseInt(st.nextToken());

    cables = new int[k];

    long sumCable = 0;

    for (int i = 0; i < k; i++) {
      int c = Integer.parseInt(br.readLine());
      sumCable += c;
      cables[i] = c;
    }
    Arrays.sort(cables);

    System.out.println(binarySearch(n, (sumCable / n)));
  }
}