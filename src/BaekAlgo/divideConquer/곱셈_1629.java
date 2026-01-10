package BaekAlgo.divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 곱셈_1629 {

  public static long dq(long a, long b, long c) {

    if (b == 1) {
      return a % c;
    }

    long half = dq(a, b / 2, c);
    long result = (half * half) % c;

    if (b % 2 == 1) {
      result = (result * a) % c;
    }

    return result;
  }



  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());
    long C = Long.parseLong(st.nextToken());

    System.out.println(dq(A, B, C));
  }
}