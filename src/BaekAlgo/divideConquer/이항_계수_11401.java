package BaekAlgo.divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이항_계수_11401 {

  // 페르마의 소정리 (소수의 나머지 연산을 할 때 나눗셈을 역원으로 곱함)
  // 다시 또 풀어볼 필요 존재

  static final long MOD = 1_000_000_007;

  static long pow(long a, long exp) {
    long result = 1;
    a %= MOD;

    while (exp > 0) {
      if ((exp & 1) == 1) {
        result = result * a % MOD;
      }
      a = a * a % MOD;
      exp >>= 1;
    }

    return result;
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    int k = Integer.parseInt(st.nextToken());

    int min = Math.min(n-k, k);

    long result = 1;

    for (int i = 1; i <= min; i++) {
      result = result * (n - i + 1) % MOD;
      result = result * pow(i, MOD - 2) % MOD;
    }

    System.out.println(result);
  }
}