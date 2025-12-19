package BaekAlgo.binarySearch.랜선_자르기_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solve2 {

  static int[] cables;

  public static int count(long len, int n) {
    int c = 0;

    for (int cable : cables) {
      c += (int) (cable / len);
      if (c >= n) {
        return n;
      }
    }

    return c;
  }

  public static long binarySearch(int n, int maxLen) {
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

    int maxLen = 0;

    cables = new int[k];

    for (int i = 0; i < k; i++) {
      int c = Integer.parseInt(br.readLine());
      maxLen = Math.max(maxLen, c);
      cables[i] = c;
    }

    System.out.println(binarySearch(n, maxLen));
  }
}