package BaekAlgo.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수_찾기_1920 {

  // 직접 mergeSort 를 구현해서 정렬
  // 그 배열에 존재하는지 이분탐색으로 검증

  // 최적화된 Arrays.sort() 보단 성능이 떨어지는 것을 확인했음

  // 메모리  시간
  // 53404	1108  --> Arrays.sort()
  // 69352	1344  --> mergeSort()

  public static void mergeSort(int[] arr) {

    if (arr.length < 2) {
      return;
    }

    int mid = arr.length / 2;

    int[] left = new int[mid];

    int[] right = new int[arr.length - mid];

    for (int i = 0; i < mid; i++) {
      left[i] = arr[i];
    }
    for (int i = mid; i < arr.length; i++) {
      right[i - mid] = arr[i];
    }

    mergeSort(left);
    mergeSort(right);

    merge(arr, left, right);
  }
  public static void merge(int[] arr, int[] left, int[] right) {
    int i = 0;
    int j = 0;
    int k = 0;

    while(i < left.length && j < right.length) {
      if (left[i] < right[j]) {
        arr[k++] = left[i++];
      } else {
        arr[k++] = right[j++];
      }
    }

    while(i < left.length) {
      arr[k++] = left[i++];
    }
    while(j < right.length) {
      arr[k++] = right[j++];
    }
  }

  public static boolean binarySearch(int n, int[] arr) {

    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (arr[mid] == n) {
        return true;
      }
      if (arr[mid] < n) {
        left = mid + 1;
      } else if (arr[mid] > n) {
        right = mid - 1;
      }
    }


    return false;
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    mergeSort(arr);

    int m = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < m; i++) {
      if (binarySearch(Integer.parseInt(st.nextToken()), arr)) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }
    }
  }
}