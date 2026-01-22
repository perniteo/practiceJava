package BaekAlgo.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 소수의_연속합_1644 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    boolean[] isNotPrime = new boolean[n+1];

    isNotPrime[1] = true;

    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (isNotPrime[i]) continue;
      for (int j = i * i; j <= n; j += i) {
        isNotPrime[j] = true;
      }
    }

    int count = 0;

    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 2; i <= n; i++) {
      if (!isNotPrime[i]) list.add(i);
    }

    int i = 0;
    int j = 0;

    int sum = 0;

    while (i < list.size()) {
      if (sum < n && j < list.size()) {
        sum += list.get(j++);
        continue;
      } else if (sum >= n) {
        if (sum == n) count++;
        sum -= list.get(i++);
        continue;
      }
      break;
    }

    System.out.println(count);
  }
}
