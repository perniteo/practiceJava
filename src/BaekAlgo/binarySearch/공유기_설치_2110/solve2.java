package BaekAlgo.binarySearch.공유기_설치_2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class solve2 {

  static int[] houses;

  static int c;

  // greedy 하게 재구성
  public static boolean canInstall(int len) {
    int install = 1;

    int last = houses[0];

    for (int i = 1; i < houses.length; i++) {

      // last 지점으로 변수를 바꿨음
      // 그에 따라 조건에 만족할 때만 갱신해서 비교하면 됨
      if (houses[i] - last >= len) {
        last = houses[i];
        install++;
      }

      if (install >= c) {
        return true;
      }
    }

    return false;
  }

  public static int binarySearch(int[] houses, int router) {

    int maxLen = 0;

    int left = 1;
    int right = houses[houses.length - 1] - houses[0];

    while (left <= right) {
      int len = (right - left) / 2 + left;

      if (canInstall(len)) {
        left = len + 1;
        maxLen = len;
      } else {
        right = len - 1;
      }
    }

    return maxLen;
  }


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    c = Integer.parseInt(st.nextToken());

    houses = new int[n];

    for (int i = 0; i < n; i++) {
      houses[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(houses);

    System.out.println(binarySearch(houses, c));

  }
}