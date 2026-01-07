package BaekAlgo.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잃어버린_괄호_1541 {

  // 쉽지만 생각만큼 쉽지는 않았다

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] expression = br.readLine().split("-");

    int num = 0;

    String[] start = expression[0].split("\\+");

    for (String n : start) {
      num += Integer.parseInt(n);
    }

    for (int i = 1; i < expression.length; i++) {
      String[] minus = expression[i].split("\\+");
      for (String n : minus) {
        num -= Integer.parseInt(n);
      }
    }

    System.out.println(num);

  }
}