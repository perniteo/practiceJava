package BaekAlgo.mergeSort;
import java.io.*;

public class 수_정렬하기2_2751 {

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

      while (i < left.length) {
        arr[k++] = left[i++];
      }
      while (j < right.length) {
        arr[k++] = right[j++];
      }

    }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    mergeSort(arr);

    for (int i : arr) {
      System.out.println(i);
    }

  }
}

