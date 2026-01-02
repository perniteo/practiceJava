
package BaekAlgo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합_1912 {

  // dp 압축 kadane 알고리즘

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int stream = -1000;

    int maxSum = -1000;

    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());

      stream = Math.max(stream + num, num);
      maxSum = Math.max(stream, maxSum);
    }

    System.out.println(maxSum);
  }
}