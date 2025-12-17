package BaekAlgo.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무_자르기_2805 {

  // 나무 자르는 cutLine 이 낮아질수록 얻는 나무양 증가 (단조)
  // 이분 탐색을 구현하여 최적해를 구함
  // 구현할 때 같은 return 값이 나올 수 있음을 생각해야 함
  // 끝까지 구하고 return 하는 이유임

  public static int binarySearch(int[] trees, int target, int maxTree) {

    int left = 0;
    int right = maxTree;

    while(left <= right) {
      int cutLine = (right - left) / 2 + left;

      long sumTree = 0;

      for (int tree : trees) {
        if (tree > cutLine) {
          sumTree += tree - cutLine;
        }
      }

      if (sumTree >= target) {
        left = cutLine + 1;
      } else {
        right = cutLine - 1;
      }
    }

    return right;
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    int m = Integer.parseInt(st.nextToken());

    int maxTree = 0;

    st = new StringTokenizer(br.readLine());

    int[] trees = new int[n];

    for (int i = 0; i < n; i++) {
      int tree = Integer.parseInt(st.nextToken());

      trees[i] = tree;

      maxTree = Math.max(maxTree, tree);
    }

    int answer = binarySearch(trees, m, maxTree);

    System.out.println(answer);

  }
}