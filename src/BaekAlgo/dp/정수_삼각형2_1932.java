package BaekAlgo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수_삼각형2_1932 {

  // 1차원 배열로 압축해서 메모리를 아낌
  // 지금 구현에 문제점은 입력값을 앞에서 부터 읽고 계산했음
  // top -> bottom 으로 1차원 dp 압축할 때는 뒤에서 부터 연산해야 함
  // 결과적으로는 dp의 idx 가 반전 됐을뿐 최대값을 return 할 수 있음

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] dp = new int[n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = i; j >= 0; j--) {
        int num = Integer.parseInt(st.nextToken());
        if (j == 0) {
          dp[j] += num;
        } else if (j == i) {
          dp[j] = num + dp[j-1];
        } else {
          dp[j] = Math.max(dp[j], dp[j-1]) + num;
        }
      }
    }

    int answer = 0;

    for (int num : dp) {
      answer = Math.max(answer, num);
    }

    System.out.println(answer);
  }
}