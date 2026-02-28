package BaekAlgo.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_폭발_9935 {

  // stack + string
  // SB로 구현

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    String str = br.readLine();

    String explosive = br.readLine();

    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);

      sb.append(c);

      if (sb.length() >= explosive.length()) {
        if (sb.substring(sb.length() - explosive.length(), sb.length()).equals(explosive)) {
          sb.setLength(sb.length() - explosive.length());
        }
      }
    }

    System.out.println(!sb.isEmpty() ? sb.toString() : "FRULA");

  }
}
